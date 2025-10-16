package com.enenzz.javase.io.test3;

import java.io.*;
import java.util.TreeSet;

public class test1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\Study\\Java\\资料\\day29-IO（其他流）\\资料\\csb.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\26698\\Desktop\\test\\csb.txt"));

        TreeSet<String> ts = new TreeSet<>();
        String str;
        while((str = br.readLine()) != null) {
            ts.add(str);
        }
        for (String t : ts) {
            bw.write(t);
            bw.newLine();
        }
        bw.close();
        br.close();
    }
}
