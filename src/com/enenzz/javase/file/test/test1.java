package com.enenzz.javase.file.test;

import java.io.File;
import java.io.IOException;

public class test1 {
    public static void main(String[] args) throws IOException {
        String s = "C:\\Users\\26698\\Desktop\\test";
        File file = new File(s);
        File sb = new File(file, "a.txt");;
        boolean b = sb.createNewFile();
        if (b) {
            System.out.println("success");
        }else {
            System.out.println("fail");
        }
    }
}
