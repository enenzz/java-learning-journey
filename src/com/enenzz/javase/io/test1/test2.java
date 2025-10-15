package com.enenzz.javase.io.test1;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class test2 {
    public static void main(String[] args) throws IOException{
        FileInputStream fi = new FileInputStream("E:\\Study\\java (1).docx");
        FileOutputStream fo = new FileOutputStream("D:\\java.docx");
        byte[] bytes = new byte[1024 * 1024 * 10];
        int len;
        while ((len = fi.read(bytes)) != -1) {
            fo.write(bytes, 0 , len);
        }
        fo.close();
        fi.close();
    }
}
