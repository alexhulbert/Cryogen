package com.alexhulbert.icewind;

import com.alexhulbert.icewind.autocol.InvalidResponseException;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import javafx.util.Pair;
import org.apache.commons.io.FileUtils;
import xmlwise.XmlParseException;

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
        byte[] fileList = client.listFiles(
                udid1,
                sid,
                0,
                (long) (Math.pow(2, 16) - 1)
        );
        Protocol.File[] files = client.parseFiles(fileList);
        byte[] getFilesRequest = client.buildGetFiles(files);
        byte[] gfResponse = client.getFiles(
                getFilesRequest,
                udid1,
                sid
        );
        Protocol.AuthChunk[] ac = client.parseGetFiles(gfResponse);
        Map<ByteString, ByteString> hd = client.buildHashDictionary(files);
        Pair<String, Protocol.FileAuth> fa = client.buildAuthorizeGet(ac, hd);
        byte[] b = client.authorizeGet(fa.getValue().toByteArray(), fa.getKey());
        Protocol.AuthorizeGet authGet = Protocol.AuthorizeGet.parseFrom(b);
        Utils.noop();
    }
}