package com.taconut.icewind;

import java.io.IOException;

/**
 *
 * @author Taconut
 */
public class test {
    public static void main(String[] args) throws IOException {
        String authData = iCloud.authenticate("username", "password");
        String infoPlist = iCloud.get_account_settings(iCloud.getDsPrsID(authData).toString(), iCloud.getMmeAuthToken(authData));
        byte[] udids = iCloud.get_backupudid(iCloud.getPNum(infoPlist), iCloud.getDsPrsID(authData).toString(), iCloud.getMmeAuthToken(infoPlist));
        String udid1 = Utils.bytesToHex(Protobuf.DeviceUdids.parseFrom(udids).getUdids(0).toByteArray());
        byte[] keys = iCloud.get_backup_keys(iCloud.getPNum(infoPlist), iCloud.getDsPrsID(authData).toString(), iCloud.getMmeAuthToken(infoPlist), udid1);
    }
}
