package com.taconut.icewind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author Taconut
 */
public class Utils {
    public static Map<String, String> getIcpHeaders() {
        Map<String, String> icph = new HashMap<>();
        icph.put("Accept", "*/*");
        icph.put("User-Agent", "MobileBackup/5.1.1 (9B206; iPhone4,1)");
        icph.put("Accept", "application/vnd.com.apple.mbs+protobuf");
        icph.put("Accept-Language", "en-US");
        icph.put("X-Apple-Request-UUID", "4EFFF273-5611-479B-A945-04DA0A0F2C3A");
        icph.put("X-Apple-MBS-Protocol-Version", "2.3");
        icph.put("X-MMe-Client-Info", "<iPhone4,1> <iPhone OS;5.1.1;9B206> <com.apple.AppleAccount/1.0 (com.apple.backupd/(null))>");
        return icph;
        //xmlwise.Plist pl = new xmlwise.Plist();
        //pl.
    }
    
    public static Map<String, String> getIcpHeaders(Map<String, String> headers) {
        headers.put("Accept", "*/*");
        headers.put("User-Agent", "MobileBackup/5.1.1 (9B206; iPhone4,1)");
        headers.put("Accept", "application/vnd.com.apple.mbs+protobuf");
        headers.put("Accept-Language", "en-US");
        headers.put("X-Apple-Request-UUID", "4EFFF273-5611-479B-A945-04DA0A0F2C3A");
        headers.put("X-Apple-MBS-Protocol-Version", "2.3");
        headers.put("X-MMe-Client-Info", "<iPhone4,1> <iPhone OS;5.1.1;9B206> <com.apple.AppleAccount/1.0 (com.apple.backupd/(null))>");
        return headers;
    }
    
    public static String get(Map<String, String> headers, String host, String path, boolean ssl) {
        String content = "";
        HttpClient dhCli = HttpClientBuilder.create().build();
        String protocol = ssl ? "https://" : "http://";
        HttpGet httpGet = new HttpGet(protocol + host + path);
        httpGet.setHeader("Host", host);
        for (Entry<String, String> header : headers.entrySet()) {
            httpGet.addHeader(header.getKey(), header.getValue());
        }
        try {
            HttpResponse hResp = dhCli.execute(httpGet);
            BufferedReader br = new BufferedReader(new InputStreamReader(hResp.getEntity().getContent()));
            
            String line = "";
            while ((line = br.readLine()) != null) {
                content += "\n";
                content += line;
            }
            if (content.length() > 1) {
                content = content.substring(1);
            } else {
                return null;
            }
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
