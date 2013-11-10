package com.taconut.icewind;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;

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
     * @param aList        app name blacklist/whitelist (depending on listColor)
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
    
    public static Integer getDsPrsID(String plist) {
        return null; //TODO: Parse plist for dsPrsID
    }
    
    public static String getMmeAuthToken(String plist) {
        return null; //TODO: Parse plist for mmeAuthToken
    }
    
    public static String authenticate(String appleID, String password) {
        Map<String, String> authHeaders = new HashMap<>();
        authHeaders.put("Authorization", "Basic " + Utils.b64Encode(appleID, password));
        return Utils.get(Utils.getIcpHeaders(authHeaders), "setup.icloud.com", "/setup/authenticate/" + appleID, true);
    }
}
