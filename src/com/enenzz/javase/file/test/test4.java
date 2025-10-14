package com.enenzz.javase.file.test;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Pattern;

public class test4 {
    static HashMap<String, Integer> hm = new HashMap<>();
    public static void main(String[] args) {
        File file = new File("C:\\Users\\26698\\Desktop\\图片");
        hm.put(".txt", 0);
        hm.put(".doc", 0);
        hm.put(".jpg", 0);
        countFile(file);
        System.out.println(hm);
    }


    public static void countFile(File src) {
        File[] files = src.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String name = file.getName();
                    if (name.endsWith(".txt")) {
                        int count = hm.get(".txt");
                        count++;
                        hm.put(".txt", count);
                    } else if (name.endsWith(".doc")) {
                        int count = hm.get(".doc");
                        count++;
                        hm.put(".doc", count);
                    } else if (name.endsWith(".jpg")) {
                        int count = hm.get(".jpg");
                        count++;
                        hm.put(".jpg", count);
                    }
                } else {
                    countFile(file);
                }
            }
        }
    }
}
