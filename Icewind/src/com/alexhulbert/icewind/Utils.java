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
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author Taconut
 */
public class Utils {
    private final static char[] hexArray = "0123456789abcdef".toCharArray();
    
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
        icph.put("X-Apple-Request-UUID", "4EFFF273-5611-479B-A945-04DA0A0F2C3A");
        icph.put("X-Apple-MBS-Protocol-Version", "1.7"); //Anything higher than 1.7 will not give you the X-MobileMe-AuthToken
        icph.put("X-MMe-Client-Info", "<iPhone4,1> <iPhone OS;5.1.1;9B206> <com.apple.AppleAccount/1.0 (com.apple.backupd/(null))>");
        return icph;
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
    
    public static String post(Map<String, String> params, Map<String, String> headers, String host, String path, boolean ssl) {
        String content = "";
        HttpClient dhCli = HttpClientBuilder.create().build();
        try {
            HttpResponse hResp = dhCli.execute(post_raw(params, headers, host, path, ssl));
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
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static byte[] post_bytes(Map<String, String> params, Map<String, String> headers, String host, String path, boolean ssl) {
        HttpClient dhCli = HttpClientBuilder.create().build();
        try {
            HttpResponse hResp = dhCli.execute(post_raw(params, headers, host, path, ssl));
            return IOUtils.toByteArray(hResp.getEntity().getContent());
        } catch(IOException | IllegalStateException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private static HttpPost post_raw(Map<String, String> params, Map<String, String> headers, String host, String path, boolean ssl) {
        String protocol = ssl ? "https://" : "http://";
        HttpPost httpPost = new HttpPost(protocol + host + path);
        List<NameValuePair> nvp = new ArrayList<NameValuePair>();
        for (Entry<String, String> parameter : params.entrySet()) {
            nvp.add(new BasicNameValuePair(parameter.getKey(), parameter.getValue()));
        }
        
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvp));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        httpPost.addHeader("Host", host);
        for (Entry<String, String> header : headers.entrySet()) {
            httpPost.addHeader(header.getKey(), header.getValue());
        }
        
        return httpPost;
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
        HttpClient dhCli = HttpClientBuilder.create().build();
        try {
            HttpResponse hResp = dhCli.execute(get_raw(headers, host, path, ssl));
            return IOUtils.toByteArray(hResp.getEntity().getContent());
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static String encode(String part1, String part2) {
        return Base64.encodeBase64String((part1 + ":" + part2).getBytes());
    }
    
    public static String encode(String part) {
        return Base64.encodeBase64String(part.getBytes());
    }
}
