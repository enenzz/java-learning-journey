package com.enenzz.javase.collection.test7;

import java.util.HashMap;
import java.util.Map;

public class test1 {
    public static void main(String[] args) {
        HashMap<Student, String> mp = new HashMap<>();

        Student s1 = new Student("张三", 12);
        Student s2 = new Student("李四", 11);
        Student s3 = new Student("王五", 13);
        mp.put(s1, "湖北");
        mp.put(s2, "上海");
        mp.put(s3, "深圳");

        System.out.println(mp);
    }
}
