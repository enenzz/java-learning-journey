package com.enenzz.javase.String.exercises;

import java.util.Random;

public class VerifyCode {
    public static void main(String[] args) {
        //生成验证码
        //内容:可以是小写字母，也可以是大写字母，还可以是数字规则:
        //长度为5
        //内容中是四位字母，1位数字。其中数字只有1位，但是可以出现在任意的位置。

        char[] arr = new char[52];

        //向数组添加a~z A~Z
        for (int i = 0; i < arr.length; i++) {
            if (i < 26) {
                arr[i] = (char)(65 + i);
                continue;
            }
            //i=26
            arr[i] = (char)(97 + i - 26);
        }

        String str = "";
        //向数组内随机添加元素
        Random r = new Random();
        int num;
        for (int i = 0; i < 4; i++) {
            num = r.nextInt(52);
            str += arr[num];
        }
        num = r.nextInt(10);
        str += num;

        System.out.println(str);

        //打乱字符串
        //首先将字符串转换为字符数组
        char[] result = str.toCharArray();
        num = r.nextInt(result.length);
        char temp = result[result.length - 1];
        result[result.length - 1] = result[num];
        result[num] = temp;

        str = new String(result);
        System.out.println(str);
    }
}
