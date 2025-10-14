package com.enenzz.javase.file.test;

import java.io.File;

public class test3 {
    public static void main(String[] args) {
        File src = new File("C:\\Users\\26698\\Desktop\\test\\aaa");
        System.out.println(src.delete());
        deleteDir(src);
    }

    public static void deleteDir(File src) {
        File[] files = src.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                file.delete();
            } else {
                deleteDir(file);
            }
        }
        src.delete();
    }
}
