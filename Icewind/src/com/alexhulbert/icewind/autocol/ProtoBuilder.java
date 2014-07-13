package com.alexhulbert.icewind.autocol;

import com.alexhulbert.icewind.Utils;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Parser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class ProtoBuilder {
    private Map<String, String> headers = Utils.getIcpHeaders();
    private boolean ssl = true;     //Always set
    private String host = null;     //Required
    private String path = "/";      //Defaults to "/"
    private byte[] body = null;     //Required if doPost
    private boolean doPost = false; //Always set
    private byte[] output;
    
    public void setSSL(boolean newValue) {
        ssl = newValue;
    }
    
    public void setBody(byte[] newValue) {
        doPost = true;
        body = newValue;
    }
    
    public void setBody() {
        doPost = false;
        body = null;
    }
    
    public void setPath(String newValue) {
        path = newValue;
    }
    
    public void setHost(String newValue) {
        host = newValue;
    }
    
    public void addHeader(String key, String value) {
        headers.put(key, value);
    }
    
    public void setHeaders(Map<String, String> newValue) {
        headers = newValue;
    }
    
    public void setHeaders() {
        headers = Utils.getIcpHeaders();
    }
    
    public void clearHeaders() {
        headers = new HashMap<String, String>();
    }
    
    private InputStream execute() throws InvalidResponseException, MissingHostException {
        if (body == null || body.length == 0)
            doPost = false;
        if (headers == null)
            headers = Utils.getIcpHeaders();
        if (path.isEmpty() || path == null)
            path = "/";
        if (host.isEmpty() || host == null)
            throw new MissingHostException("Please supply a host to send your request to.");
        
        String fullPath = (ssl ? "https://" : "http://") + host + path;
        HttpResponse hResp = null;
        HttpClient dhCli = HttpClientBuilder.create().build();
        HttpUriRequest hur;
        headers.put("Host", host);
        
        if (doPost) {
            HttpPost httpPost = new HttpPost(fullPath);
            httpPost.setEntity(new ByteArrayEntity(body));
            for (Map.Entry<String, String> header : headers.entrySet()) {
                httpPost.addHeader(header.getKey(), header.getValue());
            }
            hur = httpPost;
        } else {
            HttpGet hg = new HttpGet(fullPath);
            for (Map.Entry<String, String> header : headers.entrySet()) {
                hg.addHeader(header.getKey(), header.getValue());
            }
            hur = hg;
        }
        
        try {
            hResp = dhCli.execute(hur);
        } catch(IOException e) {
            e.printStackTrace();
            throw new InvalidResponseException("Server responded with an IOException");
        }
        
        StatusLine sl = hResp.getStatusLine();
        
        if (sl.getStatusCode() > 199 && sl.getStatusCode() < 300) {
            try {
                return hResp.getEntity().getContent();
            } catch (IOException e) {
                throw new InvalidResponseException("Could not get server response", e);
            }
        } else {
            throw new InvalidResponseException("Server responded with error " + sl.getStatusCode() + " " + sl.getReasonPhrase());
        }
    }
    
    public String getResponse() throws InvalidResponseException, MissingHostException {
        String content = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(this.execute()));
        
        try {
            String line;
            while ((line = br.readLine()) != null) {
                content += "\n";
                content += line;
            }
        } catch(IOException e) {
            throw new InvalidResponseException("Could not parse server response as string", e);
        }
        if (content.length() > 1) {
            return content.substring(1);
        }
        throw new InvalidResponseException("Server did not respond");
    }
    
    public <T extends GeneratedMessage> EasyProto<T> build(Parser<T> parser) throws InvalidResponseException, MissingHostException {
        try {
            return new EasyProto<T>(parser, IOUtils.toByteArray(this.execute()));
        } catch (IOException e) {
            throw new InvalidResponseException("Could not parse server response as string", e);
        }
    }
    
    private void checkFields() throws MissingHostException {
        
    } 
}
