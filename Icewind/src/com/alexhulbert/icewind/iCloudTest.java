package com.alexhulbert.icewind;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import javafx.util.Pair;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Taconut
 */
public class iCloudTest {
    public static void varintFirst(File inFile, File outFile) throws Exception {
        FileInputStream fis = new FileInputStream(inFile);
        CodedInputStream cis = CodedInputStream.newInstance(fis);
        FileUtils.writeByteArrayToFile(outFile, cis.readRawBytes(cis.readRawVarint32()));
    }
    
    public static void dryRun(String uname, String pass) throws IOException {
        //authenticating
        String authData = iCloud.authenticate(uname, pass);
        String dsid = iCloud.getDsPrsID(authData).toString();
        String mmeAuth = iCloud.getMmeAuthToken(authData);
        
        //Getting information
        String infoPlist = iCloud.getAccountInfo(dsid, mmeAuth);
        mmeAuth = iCloud.getMmeAuthToken(infoPlist);
        String pnum = iCloud.getPNum(infoPlist);
        
        //Retrieving list of devices
        byte[] udids = iCloud.listDevices(pnum, dsid, mmeAuth);
        String udid1 = Utils.bytesToHex(Protocol.DeviceUdids.parseFrom(udids).getUdids(0).toByteArray());
        byte[] snapshotInfo = iCloud.getInfo(pnum, dsid, mmeAuth, udid1);
        int sid = Protocol.Device.parseFrom(snapshotInfo).getBackup(0).getSnapshotID();
        byte[] fileList = iCloud.listFiles(
                pnum,
                dsid,
                mmeAuth,
                udid1,
                sid,
                0,
                (long) (Math.pow(2, 16) - 1)
        );
        Protocol.File[] files = iCloud.parseFiles(fileList);
        byte[] getFilesRequest = iCloud.buildGetFiles(files);
        byte[] gfResponse = iCloud.getFiles(
                getFilesRequest,
                pnum,
                dsid,
                mmeAuth,
                udid1,
                sid
        );
        Protocol.AuthChunk[] ac = iCloud.parseGetFiles(gfResponse);
        Map<ByteString, ByteString> hd = iCloud.buildHashDictionary(files);
        Pair<String, Protocol.FileAuth> fa = iCloud.buildAuthorizeGet(ac, hd);
        byte[] b = iCloud.authorizeGet(fa.getValue().toByteArray(), fa.getKey(), pnum, dsid, mmeAuth);
        Protocol.AuthorizeGet authGet = Protocol.AuthorizeGet.parseFrom(b);
        Utils.noop();
    }
}