package org.catacombae.hfsexplorer.iphone;

import java.util.Arrays;
import java.util.HashMap;

import java.nio.ByteBuffer;

import org.catacombae.dmgextractor.Util;

import javax.crypto.Cipher;
import java.io.*;

import javax.crypto.spec.SecretKeySpec;
public class Keybag {
    private static final int WRAP_DEVICE = 1;
    private static final int WRAP_PASSCODE = 2;
    public static enum Types {SYSTEM_KEYBAG, BACKUP_KEYBAG, ESCROW_KEYBAG, OTA_KEYBAG};
    private static final String[] KEYBAG_TAGS = {"VERS", "TYPE", "UUID", "HMCK", "WRAP", "SALT", "ITER"};
    private static final String[] CLASSKEY_TAGS = {"CLAS","WRAP","WPKY", "KTYP", "PBKY"};
    private HashMap<String, byte[]> attributes;
    public HashMap<byte[], HashMap<String, byte[]>> classKeys;
    
    public Boolean unlocked = false;

    public Keybag(byte[] data)
    {
        this.attributes = new HashMap<String, byte[]>();
        this.classKeys = new HashMap<byte[], HashMap<String, byte[]>>();
        HashMap<String, byte[]> currentClassKey = new HashMap<String, byte[]>();

        for(int i=0; i + 8 < data.length; )
        {
            String tag = Util.toASCIIString(data, i, 4);
            int len = Util.readIntBE(data, i+4);
            byte[] value = Arrays.copyOfRange(data, i+8, i+8+len);
            if (tag.equals("UUID") && !this.attributes.containsKey("UUID"))
            {
                this.attributes.put(tag, value);
            }
            else if (tag.equals("WRAP") && !this.attributes.containsKey("WRAP"))
            {
                this.attributes.put(tag, value);
            }
            else if (tag.equals("UUID"))
            {
                if (!currentClassKey.isEmpty())
                {
                    classKeys.put(currentClassKey.get("CLAS"), currentClassKey);
                }

                currentClassKey = new HashMap<String, byte[]>();
                currentClassKey.put("UUID", value);
            }
            else if (Arrays.asList(CLASSKEY_TAGS).contains(tag))
            {
                currentClassKey.put(tag, value);
            }
            else
            {
                this.attributes.put(tag, value);
            }
            i += 8 + len;
        }
    }

    public byte[] getSALT() {
        return this.attributes.get("SALT");
    }

    public int getITER() {
        return ByteBuffer.wrap(this.attributes.get("ITER")).getInt();
    }

    public Types getTYPE() {
        return Types.values()[ByteBuffer.wrap(this.attributes.get("TYPE")).getInt()];
    }
    
    public Boolean unlockWithPasscodeKey(byte[] passcodeKey) throws Exception //lol
    {
        for (HashMap<String, byte[]> classKey : this.classKeys.values()) {
            if (!classKey.containsKey("WPKY"))
                continue;
            
            byte[] k = classKey.get("WPKY");
            int wrap = ByteBuffer.wrap(classKey.get("WRAP")).getInt();
            if ((wrap & WRAP_PASSCODE) != 0) {
                k = AESUnwrap(passcodeKey, classKey.get("WPKY"));
            }
            // this is not needed
            /*if ((wrap & WRAP_DEVICE) != 0) { 
                //python code:
                //if not self.deviceKey:
                //    continue
                //k = AESdecryptCBC(k, self.deviceKey)
                
            }*/
            classKey.put("KEY", k);
        }
        this.unlocked = true;
        
        return true;
    }
    
    private byte[] AESUnwrap(byte[] key, byte[] wrapped) throws Exception
    {
        Cipher cipher = Cipher.getInstance("AESWrap");
        cipher.init(Cipher.UNWRAP_MODE, new SecretKeySpec(key, "AES"));
        return cipher.unwrap(wrapped, "AES", Cipher.SECRET_KEY).getEncoded();
    }
}
