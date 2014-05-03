package com.alexhulbert.icewind;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
        
        /*File f = new File("");
        List<Protobuf.FileAuth> ff = new ArrayList<Protobuf.FileAuth>();
        FileInputStream fis = new FileInputStream(f);
        /*do {
            ff.add(Protobuf.FileAuth.parseDelimitedFrom(fis));
        } while (fis.available() > 0);
        Protobuf.File sub = null;
        /*for (Protobuf.File fff : ff) {
            if (fff.getPath().contains("midomi.app/InfinityAppIcon29x29@2x.png")) {
                sub = ff.get(ff.indexOf(fff) + 1);
                break;
            }
        }*/
      
        //Protobuf.FileAuth willThisWork = Protobuf.FileAuth.parseFrom(fis);
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
                "50"//String.valueOf((long) Math.pow(2, 16) - 1)
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
        //List<byte[]> resps = new ArrayList<byte[]>();
        /*for(Pair<String, Protobuf.FileAuth> group : iCloud.buildAuthorizeGet(ac, iCloud.buildHashDictionary(files))) {
            resps.add(iCloud.authorizeGet(group.getValue().toByteArray(), group.getKey(), pnum, dsid, mmeAuth));
        }*/
        Map<ByteString, ByteString> hd = iCloud.buildHashDictionary(files);
        Pair<String, Protobuf.FileAuth> fa = iCloud.buildAuthorizeGet(ac, hd);
        byte[] b = iCloud.authorizeGet(fa.getValue().toByteArray(), fa.getKey(), pnum, dsid, mmeAuth);
        Utils.oblivian();
    }
}
