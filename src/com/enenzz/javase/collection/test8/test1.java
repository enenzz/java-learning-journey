package com.enenzz.javase.collection.test8;

import java.util.Comparator;
import java.util.TreeMap;

public class test1 {
    public static void main(String[] args) {
        TreeMap<Integer, String> tm = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        tm.put(2, "华为");
        tm.put(1, "小米");
        tm.put(3, "苹果");

        System.out.println(tm);
    }
}
