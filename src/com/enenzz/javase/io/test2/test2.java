package com.enenzz.javase.io.test2;

import java.io.*;

public class test2 {
    public static void main(String[] args) throws IOException {
        File src = new File("C:\\Users\\26698\\Desktop\\test2\\aaa.txt");
        File target = new File("C:\\Users\\26698\\Desktop\\test\\ccc.txt");
        copyEncryptData(src, target);
        File newFile = new File("C:\\Users\\26698\\Desktop\\test\\ddd.txt");
        copyDecryptData(target, newFile);
    }

    public static void copyEncryptData(File src, File target) throws IOException {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(target);
        int b;
        while ((b = fis.read()) != -1) {
            fos.write(encryptData(b));
        }

        fos.close();
        fis.close();
    }

    public static void copyDecryptData(File src, File target) throws IOException {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(target);
        int b;
        while ((b = fis.read()) != -1) {
            fos.write(decryptData(b));
        }

        fos.close();
        fis.close();
    }

    public static int encryptData(int num) {
        //加密数据
        return num ^ 20;
    }

    public static int decryptData(int num) {
        return num ^ 20;
    }
}
