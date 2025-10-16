package com.enenzz.javase.io.test2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringJoiner;

public class test3 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("C:\\Users\\26698\\Desktop\\test\\aaa.txt");
        StringBuilder sb = new StringBuilder();
        int ch;
        while ((ch = fr.read()) != -1) {
            sb.append((char)ch);
        }
        String str = new String(sb);
        String[] num = str.split("-");

        int[] arr = toInt(num);
        Arrays.sort(arr);

        StringJoiner sj = new StringJoiner("-");
        for (int i : arr) {
            sj.add(String.valueOf(i));
        }

        String temp = sj.toString();
        System.out.println(temp);

        FileWriter fw = new FileWriter("C:\\Users\\26698\\Desktop\\test\\eee.txt");
        fw.write(temp);
        fw.close();
        fr.close();
    }

    public static int[] toInt(String[] num) {
        if (num != null) {
            int[] arr = new int[num.length];
            for (int i = 0; i < num.length; i++) {
                arr[i] = Integer.parseInt(num[i]);
            }
            return arr;
        }
        return null;
    }
}
