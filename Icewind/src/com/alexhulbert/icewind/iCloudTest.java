/*
 * Copyright (C) 2014 admin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.alexhulbert.icewind;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.python.apache.xerces.impl.dv.util.Base64;

/**
 *
 * @author Taconut
 */
public class iCloudTest {
    public static void dryRun(String uname, String pass) throws IOException {
        //authenticating
        String authData = iCloud.authenticate(uname, new String(Base64.decode(pass), "UTF-8"));
        String dsid = iCloud.getDsPrsID(authData).toString();
        String mmeAuth = iCloud.getMmeAuthToken(authData);
        
        //Getting information
        String infoPlist = iCloud.getAccountInfo(dsid, mmeAuth);
        mmeAuth = iCloud.getMmeAuthToken(infoPlist);
        String pnum = iCloud.getPNum(infoPlist);
        
        //Retrieving list of devices
        byte[] udids = iCloud.listDevices(pnum, dsid, mmeAuth);
        String udid1 = Utils.bytesToHex(Protobuf.DeviceUdids.parseFrom(udids).getUdids(0).toByteArray());
        byte[] snapshotInfo = iCloud.getInfo(pnum, dsid, mmeAuth, udid1);
        int sid = Protobuf.Device.parseFrom(snapshotInfo).getBackup(0).getSnapshotID();
        byte[] fileList = iCloud.listFiles(
                pnum,
                dsid,
                mmeAuth,
                udid1,
                sid,
                0,
                String.valueOf((long) Math.pow(2, 16) - 1)
        );
        Protobuf.File[] files = iCloud.parseFiles(fileList);
        byte[] getFilesRequest = iCloud.buildGetFiles(files);
        byte[] gfResponse = iCloud.getFiles(
                getFilesRequest,
                pnum,
                dsid,
                mmeAuth,
                udid1,
                sid
        );
        iCloud.parseGetFiles(gfResponse);
        Utils.oblivian();
    }
}
