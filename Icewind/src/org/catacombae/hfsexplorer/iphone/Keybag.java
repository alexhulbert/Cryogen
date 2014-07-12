package org.catacombae.hfsexplorer.iphone;

import java.util.Arrays;
import java.util.HashMap;

import java.nio.ByteBuffer;

import org.catacombae.dmgextractor.Util;

public class Keybag {
    public static enum Types {SYSTEM_KEYBAG, BACKUP_KEYBAG, ESCROW_KEYBAG, OTA_KEYBAG};
    public final String[] KEYBAG_TAGS = {"VERS", "TYPE", "UUID", "HMCK", "WRAP", "SALT", "ITER", "PBKY"};
    public HashMap<String, byte[]> attributes;

    public Keybag(byte[] data)
    {
        attributes = new HashMap<String, byte[]>();

        for(int i=8; i + 8 < data.length; )
        {
            String tag = Util.toASCIIString(data, i, 4);
            int len = Util.readIntBE(data, i+4);
            if (Arrays.asList(KEYBAG_TAGS).contains(tag))
            {
                attributes.put(tag, Arrays.copyOfRange(data, i+8, i+8+len));
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
