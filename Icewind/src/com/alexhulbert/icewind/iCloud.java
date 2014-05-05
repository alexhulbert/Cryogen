package com.alexhulbert.icewind;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import org.apache.commons.io.FileUtils;
import xmlwise.Plist;
import xmlwise.XmlParseException;

/**
 *
 * @author Taconut
 */
public class iCloud {
    public static String fsep = File.separator; //Writing "File.separator" takes too long
    /**
     * Restores a decrypted iCloud backup onto the device
     * @param sshPath     path to where the device is mounted
     * @param backupPath  path to where the iCloud backup is stored
     * @param listColor   type of list used: false=blacklist, true=whitelist
     * @param aList       app name blacklist/whitelist (depending on listColor)
     */
    public static void restore(String sshPath, String backupPath, boolean listColor, List<String> aList) {
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
     * Parses the dsPrsID out of the auth plist
     * @param plist The plist from "authenticate"
     * @return The Destination Signaling Identifier
     */
    public static Integer getDsPrsID(String plist) {
        try {
            Map<String, Object> properties = Plist.fromXml(plist);
            return (Integer)((Map<String, Object>) properties.get("appleAccountInfo")).get("dsPrsID");
        } catch (XmlParseException e) {
            return null;
        }
    }
    
    /**
     * Parses the mmeAuthToken out of the authentication plist
     * @param plist The plist from "authenticate"
     * @return The Mobile Me Authentication Token
     */
    public static String getMmeAuthToken(String plist) {
        try {
            Map<String, Object> properties = Plist.fromXml(plist);
            return (String)((Map<String, Object>)properties.get("tokens")).get("mmeAuthToken");
        } catch (XmlParseException e) {
            return null;
        }
    }
    
    /**
     * Gets the number after "p" in iCloud settings (p##-mobilebackup.icloud.com)
     * @param plist The plist generated from "get_account_settings"
     * @return The pnum to be used in "get_backupudid"
     */
    public static String getPNum(String plist) {
        try {
            Map<String, Object> properties = Plist.fromXml(plist);
            Map<String, Object> mobileMe = (Map<String, Object>) properties.get("com.apple.mobileme");
            Map<String, Object> backupInfo = (Map<String, Object>) mobileMe.get("com.apple.Dataclass.Backup");
            String backupUrl = (String) backupInfo.get("url");
            //"https://p16-mobilebackup.icloud.com:443"
            return backupUrl.replaceAll("https://p([0-9]+)-mobilebackup.icloud.com:443$", "$1");
        } catch (XmlParseException e) {
            return null;
        }
    }
    
    /**
     * Authenticates you with apple
     * @param appleID
     * @param password
     * @return A plist containing your mmeAuthToken and dsPrsID
     */
    public static String authenticate(String appleID, String password) {
        Map<String, String> authHeaders = new HashMap<String, String>();
        authHeaders.put("Authorization", "Basic " + Utils.encode(appleID, password));
        return Utils.get(Utils.getIcpHeaders(authHeaders), "setup.icloud.com", "/setup/authenticate/" + appleID, true);
    }
    
    /**
     * Gets info on your account
     * @param dsPrsID The Destination Signaling Identifier
     * @param mmeAuthToken The Mobile Me Authentication Token
     * @return Information about your account
     */
    public static String getAccountInfo(String dsPrsID, String mmeAuthToken) {
        Map<String, String> authHeaders = new HashMap<String, String>();
        authHeaders.put("Authorization", "Basic " + Utils.encode(dsPrsID, mmeAuthToken));
        return Utils.get(Utils.getIcpHeaders(authHeaders), "setup.icloud.com", "/setup/get_account_settings", true);
    }
    
    /**
     * Gets the udids of the devices that have made backups on the account
     * @param pNum Partition number
     * @param dsPrsID DsPrsID
     * @param mmeAuthToken <meAuthToken (From get_account_settings)
     * @return A list of udids linked with the account (encoded with Protobuf)
     */
    public static byte[] listDevices(String pNum, String dsPrsID, String mmeAuthToken) {
        Map<String, String> authHeaders = new HashMap<String, String>();
        authHeaders.put("Authorization", "X-MobileMe-AuthToken " + Utils.encode(dsPrsID, mmeAuthToken));
        return Utils.get_bytes(Utils.getIcpHeaders(authHeaders), "p" + pNum + "-mobilebackup.icloud.com", "/mbs/" + dsPrsID, true);
    }
    
    /**
     * Gets information on the device
     * @param pNum Partition number
     * @param dsPrsID DsPrsID
     * @param mmeAuthToken MmeAuthToken (From get_account_settings)
     * @param backupUDID The udid of the device to retrieve info on
     * @return Information of the device (encoded with protobuf)
     */
    public static byte[] getInfo(String pNum, String dsPrsID, String mmeAuthToken, String backupUDID) {
        Map<String, String> authHeaders = new HashMap<String, String>();
        authHeaders.put("Authorization", "X-MobileMe-AuthToken " + Utils.encode(dsPrsID, mmeAuthToken));
        return Utils.get_bytes(Utils.getIcpHeaders(authHeaders), "p" + pNum + "-mobilebackup.icloud.com", "/mbs/" + dsPrsID + "/" + backupUDID, true);
    }
    
    /**
     * Gets the keys that will used for decrypting iCloud data
     * @param pNum Partition number
     * @param dsPrsID DsPrsID
     * @param mmeAuthToken MmeAuthToken (From get_account_settings)
     * @param backupUDID The udid of the device to retrieve info on
     * @return Keys for decrypting icloud data (encoded with protobuf)
     */
    public static byte[] getKeys(String pNum, String dsPrsID, String mmeAuthToken, String backupUDID) {
        Map<String, String> authHeaders = new HashMap<String, String>();
        authHeaders.put("Authorization", "X-MobileMe-AuthToken " + Utils.encode(dsPrsID, mmeAuthToken));
        return Utils.get_bytes(Utils.getIcpHeaders(authHeaders), "p" + pNum + "-mobilebackup.icloud.com", "/mbs/" + dsPrsID + "/" + backupUDID + "/getKeys", true);
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
    public static byte[] listFiles(String pNum, String dsPrsID, String mmeAuthToken, String backupUDID, int snapshotID, int offset, Long limit) {
        Map<String, String> authHeaders = new HashMap<String, String>();
        authHeaders.put("Authorization", "X-MobileMe-AuthToken " + Utils.encode(dsPrsID, mmeAuthToken));
        return Utils.get_bytes(Utils.getIcpHeaders(authHeaders), "p" + pNum + "-mobilebackup.icloud.com", "/mbs/" + dsPrsID + "/" + backupUDID + "/" + snapshotID + "/listFiles?offset=" + offset + (limit == null ? "" : "&limit=" + String.valueOf(limit)), true);
    }
    
    public static byte[] authorizeGet(byte[] data, String auth, String pNum, String dsPrsID, String mmeAuthToken) {
        Map<String, String> authHeaders = new HashMap<String, String>();
        authHeaders.put("Accept", "*/*");
        authHeaders.put("User-Agent", "MobileBackup/5.1.1 (9B206; iPhone4,1)");
        authHeaders.put("X-Apple-Request-UUID", "900DFACE-BABE-C001-A550-B00B1E52C0DE"); //Now that's what I call magic hex.
        authHeaders.put("X-Apple-mmcs-Proto-Version", "3.3");
        authHeaders.put("X-Apple-mme-dsid", dsPrsID);
        authHeaders.put("X-Apple-mmcs-DataClass", "com.apple.Dataclass.Backup");
        authHeaders.put("X-mme-Client-Info", "<iPhone4,1> <iPhone OS;5.1.1;9B206> <com.apple.AppleAccount/1.0 (com.apple.backupd/(null))>");
        authHeaders.put("X-Apple-mmcs-auth", auth);
        return Utils.post_bytes(data, Utils.getIcpHeaders(authHeaders), "p" + pNum + "-content.icloud.com", "/" + dsPrsID + "/authorizeGet", true);    
    }
    
    public static byte[] getFiles(byte[] data, String pNum, String dsPrsID, String mmeAuthToken, String backupUDID, int snapshotID) {
        Map<String, String> authHeaders = new HashMap<String, String>();
        authHeaders.put("Authorization", "Basic " + Utils.encode(dsPrsID, mmeAuthToken));
        return Utils.post_bytes(data, Utils.getIcpHeaders(authHeaders), "p" + pNum + "-mobilebackup.icloud.com", "/mbs/" + dsPrsID + "/" + backupUDID + "/" + snapshotID + "/getFiles", true);
    }
    
    public static Protocol.File[] parseFiles(byte[] fileList) {
        return parseFiles(fileList, null);
    }
    
    public static Protocol.File[] parseFiles(byte[] fileList, LoadingBar prog) {
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
    
    public static Protocol.AuthChunk[] parseGetFiles(byte[] getFilesResponse) {
        CodedInputStream authCis = CodedInputStream.newInstance(getFilesResponse);
        List<Protocol.AuthChunk> resps = new ArrayList<Protocol.AuthChunk>();
        try {
            for (int i = 0; !authCis.isAtEnd(); i++) {
                int len = authCis.readRawVarint32();
                try {
                    resps.add(Protocol.AuthChunk.parseFrom(authCis.readRawBytes(len)));
                } catch (InvalidProtocolBufferException ipbe) {
                    ipbe.printStackTrace();
                    //errorhandle: What's the worst that could happen? They're just Auth tokens...
                }
            }
        } catch (IOException ipbe) {
            ipbe.printStackTrace();
            //errorhandle: Meh
        }
        return resps.toArray(new Protocol.AuthChunk[resps.size()]);
    }
    
    public static byte[] buildGetFiles(Protocol.File[] files) {
        ByteArrayOutputStream oust = new ByteArrayOutputStream();
        for (Protocol.File f : files) {
            if (f.getFileSize() == 0) {
                continue;
            }
            
            Protocol.GetFiles.Builder instance = Protocol.GetFiles.newBuilder();
            instance.setHash(f.getFileName());
            try {
                instance.build().writeDelimitedTo(oust);
            } catch (IOException e) {
                //errorhandle: I guess user's not getting they're flappy bird save.
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
    
    /*
    public static List<Pair<String, byte[]>> buildAuthorizeGet(Protobuf.AuthChunk[] auch, Map<ByteString, ByteString> hashDict) {
        List<Pair<String, byte[]>> output = new ArrayList<Pair<String, byte[]>>();
        int i = 0;
        
        while (i < auch.length) {
            int startIndex = i;
            ByteArrayOutputStream group = new ByteArrayOutputStream();
            
            while (i < Math.min(startIndex + 11, auch.length)) { //TODO: Figure out what splits authGet requests
                Protobuf.FileAuth.Builder builder = Protobuf.FileAuth.newBuilder();
                Protobuf.AuthChunk.Builder main = Protobuf.AuthChunk.newBuilder(auch[i]);
                main.setChecksum(hashDict.get(auch[i].getChecksum()));
                builder.setMain(main.build());
                Protobuf.FileAuth reqPart = builder.build();
                try {
                    reqPart.writeDelimitedTo(group);
                } catch (IOException ex) {
                    //errorhandle: I'm running out of witty things to say...
                }
                i++;
            }
            
            Pair<String, byte[]> groupOutput = new Pair(
                    Utils.bytesToHex(hashDict.get(auch[startIndex].getChecksum()).toByteArray()).concat(" ") +
                    auch[startIndex].getAuthToken(),
                    group.toByteArray()
            );
            
            output.add(groupOutput);
        }
        return output;
    }
    */
}
