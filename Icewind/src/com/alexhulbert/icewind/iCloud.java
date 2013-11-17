package com.alexhulbert.icewind;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
                    if ((listColor && aList.contains(shortName)) || (!listColor && !aList.contains(aList))) {
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
        Map<String, String> authHeaders = new HashMap<>();
        authHeaders.put("Authorization", "Basic " + Utils.encode(appleID, password));
        return Utils.get(Utils.getIcpHeaders(authHeaders), "setup.icloud.com", "/setup/authenticate/" + appleID, true);
    }
    
    /**
     * Gets info on your account
     * @param dsPrsID The Destination Signaling Identifier
     * @param mmeAuthToken The Mobile Me Authentication Token
     * @return Information about your account
     */
    public static String get_account_settings(String dsPrsID, String mmeAuthToken) {
        Map<String, String> authHeaders = new HashMap<>();
        authHeaders.put("Authorization", "Basic " + Utils.encode(dsPrsID, mmeAuthToken));
        return Utils.get(Utils.getIcpHeaders(authHeaders), "setup.icloud.com", "/setup/get_account_settings", true);
    }
    
    /**
     * gets the udids of the devices that have made backups on the account
     * @param pNum Partition number
     * @param dsPrsID DsPrsID
     * @param mmeAuthToken mmeAuthToken (From get_account_settings)
     * @return a list of udids linked with the account (encoded with Protobuf)
     */
    public static byte[] get_backupudid(String pNum, String dsPrsID, String mmeAuthToken) {
        Map<String, String> authHeaders = new HashMap<>();
        authHeaders.put("Authorization", "X-MobileMe-AuthToken " + Utils.encode(dsPrsID, mmeAuthToken));
        return Utils.get_bytes(Utils.getIcpHeaders(authHeaders), "p" + pNum + "-mobilebackup.icloud.com", "/mbs/" + dsPrsID, true);
    }
    
    /**
     * Gets information on the device
     * @param pNum Partition number
     * @param dsPrsID DsPrsID
     * @param mmeAuthToken mmeAuthToken (From get_account_settings)
     * @param backupUDID the udid of the device to retrieve info on
     * @return information of the device (encoded with protobuf)
     */
    public static byte[] get_backup_info(String pNum, String dsPrsID, String mmeAuthToken, String backupUDID) {
        Map<String, String> authHeaders = new HashMap<>();
        authHeaders.put("Authorization", "X-MobileMe-AuthToken " + Utils.encode(dsPrsID, mmeAuthToken));
        return Utils.get_bytes(Utils.getIcpHeaders(authHeaders), "p" + pNum + "-mobilebackup.icloud.com", "/mbs/" + dsPrsID + "/" + backupUDID, true);
    }
    
    /**
     * Gets the keys that will used for decrypting iCloud data
     * @param pNum Partition number
     * @param dsPrsID DsPrsID
     * @param mmeAuthToken mmeAuthToken (From get_account_settings)
     * @param backupUDID the udid of the device to retrieve info on
     * @return keys for decrypting icloud data (encoded with protobuf)
     */
    public static byte[] get_backup_keys(String pNum, String dsPrsID, String mmeAuthToken, String backupUDID) {
        Map<String, String> authHeaders = new HashMap<>();
        authHeaders.put("Authorization", "X-MobileMe-AuthToken " + Utils.encode(dsPrsID, mmeAuthToken));
        return Utils.get_bytes(Utils.getIcpHeaders(authHeaders), "p" + pNum + "-mobilebackup.icloud.com", "/mbs/" + dsPrsID + "/" + backupUDID + "/getKeys", true);
    }
}
