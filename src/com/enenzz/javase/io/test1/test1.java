package com.enenzz.javase.io.test1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class test1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fi = new FileInputStream("E:\\Study\\java (1).docx");
        FileOutputStream fo = new FileOutputStream("D:\\java.docx");
        int b;
        while ((b = fi.read()) != -1) {
            fo.write(b);
        }
        fo.close();
        fi.close();
    }
}
