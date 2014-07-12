package org.catacombae.hfsexplorer.iphone;

import java.util.Arrays;
import java.util.HashMap;

import java.nio.ByteBuffer;

import org.catacombae.dmgextractor.Util;

public class Keybag {
    public static enum Types {SYSTEM_KEYBAG, BACKUP_KEYBAG, ESCROW_KEYBAG, OTA_KEYBAG};
    private static final String[] KEYBAG_TAGS = {"VERS", "TYPE", "UUID", "HMCK", "WRAP", "SALT", "ITER"};
    private static final String[] CLASSKEY_TAGS = {"CLAS","WRAP","WPKY", "KTYP", "PBKY"};
    private HashMap<String, byte[]> attributes;

    public Keybag(byte[] data)
    {
        this.attributes = new HashMap<String, byte[]>();

        //not sure if this was neccessary
        HashMap<String, byte[]> currentClassKey = new HashMap<String, byte[]>();
        HashMap<byte[], HashMap<String, byte[]>> classKeys = new HashMap<byte[], HashMap<String, byte[]>>();

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
}
