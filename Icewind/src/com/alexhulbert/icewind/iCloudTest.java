package com.alexhulbert.icewind;

import com.alexhulbert.icewind.autocol.InvalidResponseException;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
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
    
    public static void dryRun(String uname, String pass) throws InvalidResponseException {
        // Yay!
        iCloud client = new iCloud(uname, pass);
        //Retrieving list of devices
        String udid1 = client.listDevices(0);
        Protocol.Device snapshotInfo = client.getBackup(udid1);
        int sid = snapshotInfo.getBackup(0).getSnapshotID();
        Protocol.File[] files = client.listFiles(
                udid1,
                sid,
                0,
                65535l
        );
        Protocol.AuthChunk[] gfResponse = client.getFiles(files, udid1, sid);
        Map<ByteString, ByteString> hd = iCloud.buildHashDictionary(files);
        Protocol.AuthorizeGet authGet = client.authorizeGet(gfResponse, hd);
        Utils.noop();
    }
}