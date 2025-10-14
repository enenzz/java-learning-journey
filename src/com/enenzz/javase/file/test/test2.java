package com.enenzz.javase.file.test;

import java.io.File;

public class test2 {
    public static void main(String[] args) {
        File src = new File("c:\\");
        findAVI(src);
    }

    public static void findAVI(File src) {
        File[] files = src.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    //文件
                    String name = file.getName();
                    if (name.endsWith(".txt")) {
                        System.out.println(file);
                    }
                } else {
                    //文件夹
                    findAVI(file);
                }
            }
        }
    }
}
