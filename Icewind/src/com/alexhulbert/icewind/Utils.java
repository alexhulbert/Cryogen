package com.alexhulbert.icewind;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Taconut
 */
public class Utils {
    
    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
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
        Map<String, String> icph = new HashMap<>();
        icph.put("Accept", "*/*");
        icph.put("User-Agent", "MobileBackup/5.1.1 (9B206; iPhone4,1)");
        icph.put("Accept", "application/vnd.com.apple.mbs+protobuf");
        icph.put("Accept-Language", "en-US");
        icph.put("X-Apple-Request-UUID", "4EFFF273-5611-479B-A945-04DA0A0F2C3A");
        icph.put("X-Apple-MBS-Protocol-Version", "1.7"); //Anything higher than 1.7 will not give you the X-MobileMe-AuthToken
        icph.put("X-MMe-Client-Info", "<iPhone4,1> <iPhone OS;5.1.1;9B206> <com.apple.AppleAccount/1.0 (com.apple.backupd/(null))>");
        return icph;
        //xmlwise.Plist pl = new xmlwise.Plist();
        //pl.
    }
    
    public static Map<String, String> getIcpHeaders(Map<String, String> headers) {
        //headers.put("Accept", "*/*");
        headers.put("User-Agent", "MobileBackup/5.1.1 (9B206; iPhone4,1)");
        headers.put("Accept", "application/vnd.com.apple.mbs+protobuf");
        headers.put("Accept-Language", "en-US");
        headers.put("X-Apple-Request-UUID", "4EFFF273-5611-479B-A945-04DA0A0F2C3A");
        headers.put("X-Apple-MBS-Protocol-Version", "1.7"); //Anything higher than 1.7 will not give you the X-MobileMe-AuthToken
        headers.put("X-MMe-Client-Info", "<iPhone4,1> <iPhone OS;5.1.1;9B206> <com.apple.AppleAccount/1.0 (com.apple.backupd/(null))>");
        return headers;
    }
    
    private static HttpGet get_raw(Map<String, String> headers, String host, String path, boolean ssl) {
        String protocol = ssl ? "https://" : "http://";
        HttpGet httpGet = new HttpGet(protocol + host + path);
        httpGet.setHeader("Host", host);
        for (Entry<String, String> header : headers.entrySet()) {
            httpGet.addHeader(header.getKey(), header.getValue());
        }
        return httpGet;
    }
    
    public static String get(Map<String, String> headers, String host, String path, boolean ssl) {
        String content = "";
        HttpClient dhCli = HttpClientBuilder.create().build();
        try {
            HttpResponse hResp = dhCli.execute(get_raw(headers, host, path, ssl));
            BufferedReader br = new BufferedReader(new InputStreamReader(hResp.getEntity().getContent()));
            
            String line;
            while ((line = br.readLine()) != null) {
                content += "\n";
                content += line;
            }
            if (content.length() > 1) {
                return content.substring(1);
            } else {
                return null;
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static byte[] get_bytes(Map<String, String> headers, String host, String path, boolean ssl) {
        byte[] content = {};
        HttpClient dhCli = HttpClientBuilder.create().build();
        try {
            HttpResponse hResp = dhCli.execute(get_raw(headers, host, path, ssl));
            content = IOUtils.toByteArray(hResp.getEntity().getContent());
        } catch(IOException e) {
            e.printStackTrace();
        }
        return content;
    }
    
    public static String encode(String part1, String part2) {
        return Base64.encodeBase64String((part1 + ":" + part2).getBytes());
    }
    
    public static String encode(String part) {
        return Base64.encodeBase64String(part.getBytes());
    }
}
