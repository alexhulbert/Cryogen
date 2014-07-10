package com.alexhulbert.icewind;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;
import org.apache.commons.io.FileUtils;
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
    private boolean status = true;
    
    public iCloud(String appleID, String password) throws XmlParseException {
        this.authenticate(appleID, password);
        this.getAccountSettings();
    }
    
    public iCloud(String appleID, String password, LoadingBar progressBar) throws XmlParseException {
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
    private void authenticate(String appleID, String password) {
        Map<String, String> authHeaders = new HashMap<String, String>();
        authHeaders.put("Authorization", "Basic " + Utils.encode(appleID, password));
        String plist = Utils.get(Utils.getIcpHeaders(authHeaders), "setup.icloud.com", "/setup/authenticate/" + appleID, true);
        
        Map<String, Object> properties;
        try {
            properties = Plist.fromXml(plist);
        } catch(XmlParseException xpex) {
            //errorhandle: Isn't just setting the status variable good enough?
            status = false;
            return; //Too bad...
        }
        
        // Parse the dsPrsID out of the auth plist
        this.dsPrsID = (Integer)((Map<String, Object>) properties.get("appleAccountInfo")).get("dsPrsID");
        
        // Parse the mmeAuthToken out of the authentication plist
        this.mmeAuthToken = (String)((Map<String, Object>)properties.get("tokens")).get("mmeAuthToken");
    }
    
    /**
     * Gets info on your account
     * @param dsPrsID The Destination Signaling Identifier
     * @param mmeAuthToken The Mobile Me Authentication Token
     * @return Information about your account
     */
    private void getAccountSettings() throws XmlParseException {
        Map<String, String> authHeaders = new HashMap<String, String>();
        authHeaders.put("Authorization", "Basic " + Utils.encode(this.dsPrsID.toString(), this.mmeAuthToken));
        String accountInfo =  Utils.get(Utils.getIcpHeaders(authHeaders), "setup.icloud.com", "/setup/get_account_settings", true);
        Map<String, Object> properties = Plist.fromXml(accountInfo);
        Map<String, Object> mobileMe = (Map<String, Object>) properties.get("com.apple.mobileme");
        
        // Get MobileBackup URL
        this.mobileBackupUrl = ((Map<String, Object>) mobileMe.get("com.apple.Dataclass.Backup")).
                                    get("url").toString().replaceAll("https://(p[0-9]+-mobilebackup.icloud.com):443$", "$1");
        
        // Get Content URL
        this.contentUrl = ((Map<String, Object>) mobileMe.get("com.apple.Dataclass.Content")).
                                    get("url").toString().replaceAll("https://(p[0-9]+-content.icloud.com):443$", "$1");
    }
    
    /**
     * Gets the udids of the devices that have made backups on the account
     * @param pNum Partition number
     * @param dsPrsID DsPrsID
     * @param mmeAuthToken <meAuthToken (From get_account_settings)
     * @return A list of udids linked with the account (encoded with Protobuf)
     */
    public Protocol.DeviceUdids listDevices() throws InvalidProtocolBufferException {
        Map<String, String> authHeaders = new HashMap<String, String>();
        authHeaders.put("Authorization", "X-MobileMe-AuthToken " + Utils.encode(this.dsPrsID.toString(), this.mmeAuthToken));
        byte[] buffer = Utils.get_bytes(Utils.getIcpHeaders(authHeaders), this.mobileBackupUrl, "/mbs/" + this.dsPrsID.toString(), true);
        return Protocol.DeviceUdids.parseFrom(buffer);
    }
    
    public String listDevices(int index) throws InvalidProtocolBufferException {
        return Utils.bytesToHex(this.listDevices().getUdids(index).toByteArray());
    }
            
    
    /**
     * Gets information on the device
     * @param pNum Partition number
     * @param dsPrsID DsPrsID
     * @param mmeAuthToken MmeAuthToken (From get_account_settings)
     * @param backupUDID The udid of the device to retrieve info on
     * @return Information of the device (encoded with protobuf)
     */
    public byte[] getBackup(String backupUDID) {
        Map<String, String> authHeaders = new HashMap<String, String>();
        authHeaders.put("Authorization", "X-MobileMe-AuthToken " + Utils.encode(this.dsPrsID.toString(), this.mmeAuthToken));
        return Utils.get_bytes(Utils.getIcpHeaders(authHeaders), this.mobileBackupUrl, "/mbs/" + this.dsPrsID.toString() + "/" + backupUDID, true);
    }
    
    /**
     * Gets the keys that will used for decrypting iCloud data
     * @param pNum Partition number
     * @param dsPrsID DsPrsID
     * @param mmeAuthToken MmeAuthToken (From get_account_settings)
     * @param backupUDID The udid of the device to retrieve info on
     * @return Keys for decrypting icloud data (encoded with protobuf)
     */
    public byte[] getKeys(String backupUDID) {
        Map<String, String> authHeaders = new HashMap<String, String>();
        authHeaders.put("Authorization", "X-MobileMe-AuthToken " + Utils.encode(this.dsPrsID.toString(), this.mmeAuthToken));
        return Utils.get_bytes(Utils.getIcpHeaders(authHeaders), this.mobileBackupUrl, "/mbs/" + this.dsPrsID.toString() + "/" + backupUDID + "/getKeys", true);
    }
    
    /**
     * Gets Uris for the iCloud backup data
     * @param pNum Partition number
     * @param dsPrsID DsPrsID
     * @param mmeAuthToken MmeAuthToken (From get_account_settings)
     * @param backupUDID The udid of the device to retrieve info on
     * @param snapshotID The ID of the backup to get
     * @param offset Where to start
     * @param limit Max length
     * @return A list of files to download
     */
    public byte[] listFiles(String backupUDID, int snapshotID, int offset, Long limit) {
        Map<String, String> authHeaders = new HashMap<String, String>();
        authHeaders.put("Authorization", "X-MobileMe-AuthToken " + Utils.encode(this.dsPrsID.toString(), this.mmeAuthToken));
        return Utils.get_bytes(Utils.getIcpHeaders(authHeaders), this.mobileBackupUrl, "/mbs/" + this.dsPrsID.toString() + "/" + backupUDID + "/" + snapshotID + "/listFiles?offset=" + offset + (limit == null ? "" : "&limit=" + String.valueOf(limit)), true);
    }
    
    public byte[] authorizeGet(byte[] data, String auth) {
        Map<String, String> authHeaders = new HashMap<String, String>();
        authHeaders.put("Accept", "*/*");
        authHeaders.put("User-Agent", "MobileBackup/5.1.1 (9B206; iPhone4,1)");
        authHeaders.put("X-Apple-Request-UUID", "900DFACE-BABE-C001-A550-B00B1E52C0DE"); //Now that's what I call magic hex.
        authHeaders.put("X-Apple-mmcs-Proto-Version", "3.3");
        authHeaders.put("X-Apple-mme-dsid", this.dsPrsID.toString());
        authHeaders.put("X-Apple-mmcs-DataClass", "com.apple.Dataclass.Backup");
        authHeaders.put("X-mme-Client-Info", "<iPhone4,1> <iPhone OS;5.1.1;9B206> <com.apple.AppleAccount/1.0 (com.apple.backupd/(null))>");
        authHeaders.put("X-Apple-mmcs-auth", auth);
        return Utils.post_bytes(data, Utils.getIcpHeaders(authHeaders), this.contentUrl, "/" + this.dsPrsID.toString() + "/authorizeGet", true);    
    }
    
    public byte[] getFiles(byte[] data, String backupUDID, int snapshotID) {
        Map<String, String> authHeaders = new HashMap<String, String>();
        authHeaders.put("Authorization", "Basic " + Utils.encode(this.dsPrsID.toString(), this.mmeAuthToken));
        return Utils.post_bytes(data, Utils.getIcpHeaders(authHeaders), this.mobileBackupUrl, "/mbs/" + this.dsPrsID.toString() + "/" + backupUDID + "/" + snapshotID + "/getFiles", true);
    }
    
    public Protocol.File[] parseFiles(byte[] fileList) {
        CodedInputStream fileCounter = CodedInputStream.newInstance(fileList);
        CodedInputStream fileParser = CodedInputStream.newInstance(fileList);
        int numFiles = 0;
        
        if (prog != null) {
            prog.activate(true);
            prog.intermediate();
            prog.status("Calculating File Size..."); //Just like Windows Explorer!
        }
        
        try {
            for (numFiles = 0; !fileCounter.isAtEnd(); numFiles++) {
                int j = fileCounter.readRawVarint32();
                fileCounter.skipRawBytes(j);
            }
        } catch (IOException e) {
            //errorhandle: Well sh[a-z]{1}t... This isn't supposed to happen.
        }
        
        if (prog != null) {
            prog.percentage();
        }
        
        Protocol.File[] files = new Protocol.File[numFiles];
        try {
            for (int i = 0; !fileParser.isAtEnd(); i++) {
                int len = fileParser.readRawVarint32();
                try {
                    files[i] = Protocol.File.parseFrom(fileParser.readRawBytes(len));
                } catch (InvalidProtocolBufferException ipbe) {
                    files[i] = null;
                    //errorhandle: REPORT THIS TO THE DEVELOPER!!! (me)
                }
                
                if (prog != null) {
                    prog.progress(((i + 1) / numFiles) * 100);
                    prog.status("Parsing File list: " + (((i + 1) / numFiles) * 100) + "% done");
                }
            }
        } catch (IOException e) {
            //errorhandle: Remember: Its always the user's fault, not the programmer's.
        }
        
        if (prog != null) {
            prog.activate(false);
        }
        return files;
    }
    
    public Protocol.AuthChunk[] parseGetFiles(byte[] getFilesResponse) {
        List<Protocol.AuthChunk> resps = new ArrayList<Protocol.AuthChunk>();
        ByteArrayInputStream bais = new ByteArrayInputStream(getFilesResponse);
        while (bais.available() > 0) {
            try {
                resps.add(Protocol.AuthChunk.parseDelimitedFrom(bais));
            } catch(IOException e) {
                //errorhandle: I'm putting these here so I know where to add error handling later
            }
        }
        return resps.toArray(new Protocol.AuthChunk[resps.size()]);
    }
    
    public byte[] buildGetFiles(Protocol.File[] files) {
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
        return oust.toByteArray();
    }
    
    public static Map<ByteString, ByteString> buildHashDictionary(Protocol.File[] sources) {
        Map<ByteString, ByteString> dict = new HashMap<ByteString, ByteString>(); //A HashMap of mapped Hashes
        for (Protocol.File sauce : sources) { 
            dict.put(sauce.getFileName(), sauce.getAltFileName());
        }
        return dict;
    }
    
    public static Pair<String, Protocol.FileAuth> buildAuthorizeGet(Protocol.AuthChunk[] auch, Map<ByteString, ByteString> hashDict) {
        Protocol.FileAuth.Builder builder = Protocol.FileAuth.newBuilder();
        for (Protocol.AuthChunk file : auch) {
            Protocol.AuthChunk.Builder subBuilder = Protocol.AuthChunk.newBuilder();
            subBuilder.setAuthToken(file.getAuthToken());
            subBuilder.setChecksum(hashDict.get(file.getChecksum()));
            builder.addMain(subBuilder.build());
        }
        return new Pair<String, Protocol.FileAuth>(
                Utils.bytesToHex(hashDict.get(auch[0].getChecksum()).toByteArray()).concat(" ") +
                auch[0].getAuthToken(),
                builder.build()
        );
    }
    
    /**
     * Used to check if there have been any errors, etc.
     * @return Whether everything has succeeded so far
     */
    public boolean getStatus() {
        return this.status;
    }
    
    //Maybe implement generics with this? It could be incorperated into EasyProto.
    private static Object ProtobufRequest(String host, String method, String url, byte[] body, String headers, Object msg)
    {
        
        return null;
    }
}
