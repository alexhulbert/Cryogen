package com.alexhulbert.icewind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author Taconut
 */
public class Utils {
    private final static char[] hexArray = "0123456789abcdef".toCharArray();
    
    /**
     * A really sick name for a really stupid function.
     * Yup. This does absolutely nothing at all.
     * Call me an idiot if you want.
     */
    public static void noop() {
        //I use this as a point for breakpoints.
        //This is also a good control, since it should never raise an Exception (I hope)
    }
    
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        int v;
        for ( int j = 0; j < bytes.length; j++ ) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
    
    public static Map<String, String> getIcpHeaders() {
        Map<String, String> icph = new HashMap<String, String>();
        icph.put("Accept", "*/*");
        icph.put("User-Agent", "MobileBackup/5.1.1 (9B206; iPhone4,1)");
        icph.put("Accept", "application/vnd.com.apple.mbs+protobuf");
        icph.put("Accept-Language", "en-US");
        icph.put("X-Apple-Request-UUID", "900DFACE-BABE-C001-A550-B00B1E52C0DE");
        icph.put("X-Apple-MBS-Protocol-Version", "1.7"); //Anything higher than 1.7 will not give you the X-MobileMe-AuthToken
        icph.put("X-MMe-Client-Info", "<iPhone4,1> <iPhone OS;5.1.1;9B206> <com.apple.AppleAccount/1.0 (com.apple.backupd/(null))>");
        return icph;
    }
    
    public static Map<String, String> getIcpHeaders(Map<String, String> headers) {
        //headers.put("Accept", "*/*");
        headers.put("User-Agent", "MobileBackup/5.1.1 (9B206; iPhone4,1)");
        headers.put("Accept", "application/vnd.com.apple.mbs+protobuf");
        headers.put("Accept-Language", "en-US");
        headers.put("X-Apple-Request-UUID", "900DFACE-BABE-C001-A550-B00B1E52C0DE");
        headers.put("X-Apple-MBS-Protocol-Version", "1.7"); //Anything higher than 1.7 will not give you the X-MobileMe-AuthToken
        headers.put("X-MMe-Client-Info", "<iPhone4,1> <iPhone OS;5.1.1;9B206> <com.apple.AppleAccount/1.0 (com.apple.backupd/(null))>");
        return headers;
    }
    
    public static String encode(String part1, String part2) {
        return Base64.encodeBase64String((part1 + ":" + part2).getBytes());
    }
    
    public static String encode(String part) {
        return Base64.encodeBase64String(part.getBytes());
    }
}
