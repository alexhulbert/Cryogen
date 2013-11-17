package com.alexhulbert.icewind;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Taconut
 */
public class test {
    public static void main(String[] args) throws IOException {
        String authData = iCloud.authenticate("username", "password");
        String infoPlist = iCloud.get_account_settings(iCloud.getDsPrsID(authData).toString(), iCloud.getMmeAuthToken(authData));
        Log.log(iCloud.get_url(iCloud.getPNum(infoPlist), iCloud.getDsPrsID(authData).toString(), iCloud.getMmeAuthToken(infoPlist)));
        //byte[] udids = iCloud.get_backupudid(iCloud.getPNum(infoPlist), iCloud.getDsPrsID(authData).toString(), iCloud.getMmeAuthToken(infoPlist));
        //String udid1 = Utils.bytesToHex(Protobuf.DeviceUdids.parseFrom(udids).getUdids(0).toByteArray());
        //byte[] files = iCloud.get_files(iCloud.getPNum(infoPlist), iCloud.getDsPrsID(authData).toString(), iCloud.getMmeAuthToken(infoPlist), udid1, 147, 0, "0");
    }
}
