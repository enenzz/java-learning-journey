package com.enenzz.javase.io.test2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class test1 {
    public static void main(String[] args) throws IOException {
        File src = new File("D:\\Study\\Java\\资料\\day28-IO（字节流&字符流）");
        File target = new File("C:\\Users\\26698\\Desktop\\test");
        copyFile(src, target);
    }

    //C:\Users\26698\Desktop\test
    public static void copyFile(File src, File target) throws IOException {
        target.mkdirs();
        File[] files = src.listFiles();
        if (files != null){
            for (File file : files) {
                if (file.isFile()) {
                    //文件
                    FileInputStream fi = new FileInputStream(file);
                    FileOutputStream fo = new FileOutputStream(new File(target, file.getName()));
                    int len;
                    byte[] bytes = new byte[1024 * 1024 * 5];
                    while ((len = fi.read(bytes)) != -1) {
                        fo.write(bytes, 0, len);
                    }
                    fo.close();
                    fi.close();
                } else {
                    copyFile(file, new File(target, file.getName()));
                }
            }
        }
    }
}
