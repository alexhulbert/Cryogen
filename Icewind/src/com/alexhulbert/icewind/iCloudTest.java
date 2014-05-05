package com.alexhulbert.icewind;

import com.google.protobuf.ByteString;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;
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
                (long) (Math.pow(2, 16) - 1)
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
        Protobuf.AuthChunk[] ac = iCloud.parseGetFiles(gfResponse);
        Map<ByteString, ByteString> hd = iCloud.buildHashDictionary(files);
        Pair<String, Protobuf.FileAuth> fa = iCloud.buildAuthorizeGet(ac, hd);
        byte[] b = iCloud.authorizeGet(fa.getValue().toByteArray(), fa.getKey(), pnum, dsid, mmeAuth);
        Protobuf.AuthorizeGet authGet = Protobuf.AuthorizeGet.parseFrom(b);
        Utils.oblivian();
    }
}