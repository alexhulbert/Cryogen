package com.alexhulbert.icewind;

import com.alexhulbert.icewind.autocol.EasyProto;
import com.alexhulbert.icewind.autocol.InvalidResponseException;
import com.alexhulbert.icewind.autocol.ProtoBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import de.rtner.security.auth.spi.PBKDF2Engine;
import de.rtner.security.auth.spi.PBKDF2Parameters;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;
import org.apache.commons.io.FileUtils;
import org.catacombae.hfsexplorer.iphone.Keybag;
import xmlwise.Plist;
import xmlwise.XmlParseException;

/**
 *
 * @author Taconut
 */
public class iCloud {
    private static String fsep = File.separator; //Writing "File.separator" takes too long
    private Integer dsPrsID;
    private String mmeAuthToken;
    private String mobileBackupUrl;
    private String contentUrl;
    private LoadingBar prog = null;

    public iCloud(String appleID, String password) throws InvalidResponseException {
        this.authenticate(appleID, password);
        this.getAccountSettings();
    }

    public iCloud(String appleID, String password, LoadingBar progressBar) throws InvalidResponseException {
        this.authenticate(appleID, password);
        this.getAccountSettings();
        this.prog = progressBar;
    }

    /**
     * Restores a decrypted iCloud backup onto the device (Just a Proof of Concept for now)
     * @param sshPath     path to where the device is mounted
     * @param backupPath  path to where the iCloud backup is stored
     * @param listColor   type of list used: false=blacklist, true=whitelist
     * @param aList       app name blacklist/whitelist (depending on listColor)
     */
    private static void restore(String sshPath, String backupPath, boolean listColor, List<String> aList) {
        for (File F_UID : new File(sshPath + "/var/mobile/Applications".replace("/", fsep)).listFiles()) {
            for (File plist : new File(F_UID.getPath() + "/Library/Prefrences".replace("/", fsep)).listFiles()) {
                String bid = plist.getName().substring(0, plist.getName().length() - 4);
                if (new File(backupPath + fsep + "AppDomain-" + bid).exists()) {
                    Log.log("App found: " + bid + "!");
                    String shortName = ""; //Example: "Stable" for chrome or "Safari" for Safari
                    for (File aPart : F_UID.listFiles()) {
                        if (aPart.getName().endsWith(".app")) {
                            shortName = aPart.getName().substring(0, aPart.getName().length() - 4);
                            break;
                        }
                    }
                    if (listColor == aList.contains(shortName)) {
                        Log.log("Restoring data for \"" + shortName + ".app\"...");
                        try {
                            FileUtils.copyDirectory(new File(backupPath + fsep + "AppDomain-" + bid), F_UID);
                        } catch (IOException ex) {
                            Log.log("ERROR: Could not copy data for \"" + shortName + ".app\"");
                            ex.printStackTrace();
                        }
                        Log.log("Done!");
                    } else {
                        Log.log("Not restoring data for \"" + shortName + ".app.\"");
                    }
                } else {
                    Log.log("Match not found for \"" + bid + ",\" ignoring.");
                }
            }
        }
    }


    /**
     * Authenticates you with apple
     * @param appleID Username/Email
     * @param password Password for your AppleID
     * @return A plist containing your mmeAuthToken and dsPrsID
     */
    private void authenticate(String appleID, String password) throws InvalidResponseException {
        ProtoBuilder pb = new ProtoBuilder();
        pb.setHost("setup.icloud.com");
        pb.setPath("/setup/authenticate/" + appleID);
        pb.addHeader("Authorization", "Basic " + Utils.encode(appleID, password));
        String plist = pb.getResponse();
        
        Map<String, Object> properties;
        try {
            properties = Plist.fromXml(plist);
        } catch(XmlParseException xpex) {
            throw new InvalidResponseException("Response was not properly encoded in XML", xpex);
        }
        
        dsPrsID = (Integer)((Map<String, Object>) properties.get("appleAccountInfo")).get("dsPrsID");   //Parse the dsPrsID out of the auth plist
        mmeAuthToken = (String)((Map<String, Object>)properties.get("tokens")).get("mmeAuthToken");     //Parse the mmeAuthToken out of the authentication plist
    }

    /**
     * Gets info on your account
     * @param dsPrsID The Destination Signaling Identifier
     * @param mmeAuthToken The Mobile Me Authentication Token
     * @return Information about your account
     */
    private void getAccountSettings() throws InvalidResponseException {
        ProtoBuilder pb = new ProtoBuilder();
        pb.setHost("setup.icloud.com");
        pb.setPath("/setup/get_account_settings");
        pb.addHeader("Authorization", "Basic " + Utils.encode(this.dsPrsID.toString(), this.mmeAuthToken));
        String accountInfo = pb.getResponse();
        
        Map<String, Object> properties;
        try {
            properties = Plist.fromXml(accountInfo);
        } catch (XmlParseException xpex) {
            throw new InvalidResponseException("Response was not properly encoded in XML", xpex);
        }
        
        Map<String, Object> mobileMe = (Map<String, Object>) properties.get("com.apple.mobileme");
        mobileBackupUrl = ((Map<String, Object>) mobileMe.get("com.apple.Dataclass.Backup")).get("url").toString()
                .replaceAll("https://(p[0-9]+-mobilebackup.icloud.com):443$", "$1");    //Get MobileBackup URL
        
        contentUrl = ((Map<String, Object>) mobileMe.get("com.apple.Dataclass.Content")).get("url").toString()
                .replaceAll("https://(p[0-9]+-content.icloud.com):443$", "$1");         //Get Content URL
    }

    /**
     * Gets the udids of the devices that have made backups on the account
     * @return A list of udids linked with the account (encoded with Protocol Buffers)
     * @throws com.alexhulbert.icewind.autocol.InvalidResponseException Invalid response to the protobuf
     */
    public Protocol.DeviceUdids listDevices() throws InvalidResponseException {
        ProtoBuilder pb = new ProtoBuilder();
        pb.setHost(mobileBackupUrl);
        pb.setPath("/mbs/" + dsPrsID);
        pb.addHeader("Authorization", "Basic " + Utils.encode(dsPrsID.toString(), mmeAuthToken));
        try {
            return pb.build(Protocol.DeviceUdids.PARSER).parse();
        } catch (InvalidProtocolBufferException ipbe) {
            throw new InvalidResponseException("Response was not properly encoded in Protobuf format", ipbe);
        }
    }

    /**
     * Gets device UDID with specific index. Useful for iterating through all the devices
     * @param index the index at which to retrieve the UDID. Starts at zero.
     * @return A UDID at that index
     * @throws InvalidResponseException 
     */
    public String listDevices(int index) throws InvalidResponseException {
        return Utils.bytesToHex(listDevices().getUdids(index).toByteArray());
    }


    /**
     * Gets information about the specified UDID
     * @param backupUDID The udid of the device to retrieve info on
     * @throws com.alexhulbert.icewind.autocol.InvalidResponseException Invalid response to the protobuf
     * @return Information of the device (encoded with protobuf)
     */
    public Protocol.Device getBackup(String backupUDID) throws InvalidResponseException {
        ProtoBuilder pb = new ProtoBuilder();
        pb.setHost(mobileBackupUrl);
        pb.setPath(dsPrsID + "/" + backupUDID);
        pb.addHeader("Authorization", "X-MobileMe-AuthToken " + Utils.encode(dsPrsID.toString(), mmeAuthToken));
        try {
            return pb.build(Protocol.Device.PARSER).parse();
        } catch (InvalidProtocolBufferException ipbe) {
            throw new InvalidResponseException("Response was not properly encoded in Protobuf format", ipbe);
        }
    }

    /**
     * Gets the keys that will used for decrypting iCloud data
     * @param backupUDID The udid of the device to retrieve info on
     * @return Keys for decrypting icloud data (encoded with protobuf)
     * @throws com.alexhulbert.icewind.autocol.InvalidResponseException Invalid response to the protobuf
     */
    public Protocol.Keys getKeys(String backupUDID) throws InvalidResponseException {
        ProtoBuilder pb = new ProtoBuilder();
        pb.setHost(mobileBackupUrl);
        pb.setPath("/mbs/" + dsPrsID + "/" + backupUDID + "/getKeys");
        pb.addHeader("Authorization", "X-MobileMe-AuthToken " + Utils.encode(dsPrsID.toString(), mmeAuthToken));
        try {
            return pb.build(Protocol.Keys.PARSER).parse();
        } catch (InvalidProtocolBufferException ipbe) {
            throw new InvalidResponseException("Response was not properly encoded in Protobuf format", ipbe);
        }
    }

    /**
     * Gets Uris for the iCloud backup data
     * @param backupUDID The UDID of the device to retrieve info on
     * @param snapshotID The ID of the backup to get
     * @param offset Where to start
     * @param limit Max length
     * @throws com.alexhulbert.icewind.autocol.InvalidResponseException Invalid response to the protobuf
     * @return A list of files to download
     */
    public Protocol.File[] listFiles(String backupUDID, int snapshotID, int offset, Long limit) throws InvalidResponseException {
        ProtoBuilder pb = new ProtoBuilder();
        pb.setHost(mobileBackupUrl);
        pb.setPath("/mbs/" + this.dsPrsID.toString() + "/" + backupUDID + "/" + snapshotID + "/listFiles");
        pb.addHeader("offset", String.valueOf(offset));
        pb.addHeader("Authorization", "X-MobileMe-AuthToken " + Utils.encode(dsPrsID.toString(), mmeAuthToken));
        if (limit != null) {
            pb.addHeader("limit", String.valueOf(limit));
        }
        EasyProto<Protocol.File> ep = pb.build(Protocol.File.PARSER);
        if (prog != null) {
            prog.activate(true);
            prog.intermediate();
            prog.status("Calculating File Size..."); //Just like Windows Explorer!
            Protocol.File[] response = ep.parseVarint(prog, "Parsing File List");
            prog.activate(false);
            return response;
        } else {
            return ep.parseVarint();
        }
    }
    
    /**
     * Gets keys, info, etc. from files
     * @param auch GetFiles Response
     * @param hashDict Hash Dictionary
     * @return Invalid response to the protobuf
     * @throws com.alexhulbert.icewind.autocol.InvalidResponseException Invalid response to the protobuf
     */
    public Protocol.FileAuth authorizeGet(Protocol.AuthChunk[] auch, Map<ByteString, ByteString> hashDict) throws InvalidResponseException {
        Protocol.FileAuth.Builder builder = Protocol.FileAuth.newBuilder();
        for (Protocol.AuthChunk file : auch) {
            Protocol.AuthChunk.Builder subBuilder = Protocol.AuthChunk.newBuilder();
            subBuilder.setAuthToken(file.getAuthToken());
            subBuilder.setChecksum(hashDict.get(file.getChecksum()));
            builder.addMain(subBuilder.build());
        }
        
        ProtoBuilder pb = new ProtoBuilder();
        pb.setHost(contentUrl);
        pb.setPath("/" + dsPrsID + "/authorizeGet");
        pb.setBody(builder.build().toByteArray());
        pb.addHeader("Accept", "*/*");
        pb.addHeader("User-Agent", "MobileBackup/5.1.1 (9B206; iPhone4,1)");
        pb.addHeader("X-Apple-Request-UUID", "900DFACE-BABE-C001-A550-B00B1E52C0DE"); //Now that's what I call magic hex.
        pb.addHeader("X-Apple-mmcs-Proto-Version", "3.3");
        pb.addHeader("X-Apple-mme-dsid", dsPrsID.toString());
        pb.addHeader("X-Apple-mmcs-DataClass", "com.apple.Dataclass.Backup");
        pb.addHeader("X-mme-Client-Info", "<iPhone4,1> <iPhone OS;5.1.1;9B206> <com.apple.AppleAccount/1.0 (com.apple.backupd/(null))>");
        pb.addHeader("X-Apple-mmcs-auth", Utils.bytesToHex(hashDict.get(auch[0].getChecksum()).toByteArray()).concat(" ") + auch[0].getAuthToken());
        try {
            return pb.build(Protocol.FileAuth.PARSER).parse();
        } catch (InvalidProtocolBufferException ipbe) {
            throw new InvalidResponseException("Response was not properly encoded in Protobuf format", ipbe);
        }
    }

    /**
     * Gets Auth tokens for files (used for verification in authorizeGet)
     * @param files ListFiles Response
     * @param backupUDID UDID of the device
     * @param snapshotID Id of the backup
     * @return A list of file auth tokens
     * @throws com.alexhulbert.icewind.autocol.InvalidResponseException Invalid response to the protobuf
     */
    public Protocol.AuthChunk[] getFiles(Protocol.File[] files, String backupUDID, int snapshotID) throws InvalidResponseException {
        ByteArrayOutputStream oust = new ByteArrayOutputStream();
        for (Protocol.File f : files) {
            if (f == null || f.getFileSize() == 0) {
                continue;
            }

            Protocol.GetFiles.Builder instance = Protocol.GetFiles.newBuilder();
            instance.setHash(f.getFileName());
            try {
                instance.build().writeDelimitedTo(oust);
            } catch (IOException e) {
                //errorhandle: I guess user's not getting their flappy bird save.
            }
        }
        ProtoBuilder pb = new ProtoBuilder();
        pb.setHost(mobileBackupUrl);
        pb.setPath(String.format("/mbs/%s/%s/%s/getFiles", dsPrsID, backupUDID, snapshotID));
        pb.addHeader("Authorization", Utils.encode(dsPrsID.toString(), mmeAuthToken));
        return pb.build(Protocol.AuthChunk.PARSER).parseVarint();
    }

    public static Map<ByteString, ByteString> buildHashDictionary(Protocol.File[] sources) {
        Map<ByteString, ByteString> dict = new HashMap<ByteString, ByteString>(); //A HashMap of mapped Hashes
        for (Protocol.File sauce : sources) {
            dict.put(sauce.getFileName(), sauce.getAltFileName());
        }
        return dict;
    }

    public void downloadBackup(String backupUDID, String outputFolder) throws InvalidResponseException {
        byte[] snapshotInfo = this.getBackup(backupUDID);
        int sid = Protocol.Device.parseFrom(snapshotInfo).getBackup(0).getSnapshotID();
        Protocol.File[] files = this.listFiles(
                backupUDID,
                sid,
                0,
                (long) (Math.pow(2, 16) - 1)
        );
        Protocol.Keys actualKeys = this.getKeys(backupUDID);
        Keybag kbag = new Keybag(actualKeys.getKeySet(1).getDataBytes().toByteArray());

        if (kbag.getTYPE() != Keybag.Types.BACKUP_KEYBAG && kbag.getTYPE() != Keybag.Types.OTA_KEYBAG)
        {
            //Oops, something bad happened
            return;
        }

        String passcode = new String(actualKeys.getKeySet(0).getDataBytes().toByteArray());

        PBKDF2Parameters p = new PBKDF2Parameters("HmacSHA1", "UTF-8", kbag.getSALT(), kbag.getITER());
        PBKDF2Engine e = new PBKDF2Engine(p);
        p.setDerivedKey(e.deriveKey(passcode));
        Utils.noop();
    }
}
