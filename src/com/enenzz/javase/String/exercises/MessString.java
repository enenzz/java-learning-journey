package com.enenzz.javase.String.exercises;

import java.util.Random;

public class MessString {
    public static void main(String[] args) {
        //键盘输入字符串然后打乱
        String str = "abcde";

        //将字符串转换为字符数字
        char[] arr = str.toCharArray();

        //利用随机索引进行打乱
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int num = r.nextInt(arr.length);
            char temp = arr[i];
            arr[i] = arr[num];
            arr[num] = temp;
        }

        //根据字符数字创建字符串对象
        String result = new String(arr);
        System.out.println(result);
    }
}
