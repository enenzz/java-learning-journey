package com.enenzz.javase.String.exercises;

public class RotateString {
    public static void main(String[] args) {
        /*给定两个字符串，A和B。A的旋转操作就是将A
        最左边的字符移动到最右边。例如，若A='abcde'，
        在移动一次之后结果就是'bcdea如果在若干次调整操作之后，A能变成B，
        那么返回True。如果不能匹配成功，则返回false*/
        String A = "abcde";
        String B = "deabc";
        System.out.println(check(A, B));

    }

    public static String rotate(String str) {
        //方法1 通过subString来选择字符串
        return str.substring(1) + str.substring(0, 1);

        //方法2 通过定义字符数组来实习
    }

    public static boolean check(String A, String B) {
        for (int i = 0; i < A.length(); i++) {
            A = rotate(A);
            if (A.equals(B)) {
                return true;
            }
        }
        return false;
    }
}
