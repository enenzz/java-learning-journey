package com.enenzz.javase.io.test5;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class test1 {
    public static void main(String[] args) throws IOException {
        String urlName = "https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0";
        System.out.println(craw(urlName));
        
    }
    
    public static String craw(String net) throws IOException {
        StringBuilder sb = new StringBuilder();
        URL url = new URL(net);
        URLConnection conn = url.openConnection();
        InputStreamReader isr = new InputStreamReader(conn.getInputStream());
        int ch;
        while ((ch = isr.read()) != -1) {
            sb.append((char)ch);
        }
        isr.close();
        return sb.toString();



    }
}
