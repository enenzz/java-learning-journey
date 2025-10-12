package com.enenzz.javase.collection.test8;

import java.util.TreeMap;

public class test2 {
    public static void main(String[] args) {
        TreeMap<Student, String> tm = new TreeMap<>();

        Student s2 = new Student("lisi", 19);
        Student s3 = new Student("wangwu", 20);
        Student s1 = new Student("zhangsna", 18);

        tm.put(s1, "shanghai");
        tm.put(s2, "shengzheng");
        tm.put(s3, "guangzhou");

        System.out.println(tm);
    }
}
