package com.enenzz.javase.Stream.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

public class test1 {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();

        Collections.addAll(arr, "zhangsan-15","lisi-16", "wangwu-17", "zjam-19");
/*        arr.stream().filter(s -> s.startsWith("z")).forEach(s -> System.out.println(s));
        System.out.println("================");
        arr.stream().forEach(s -> System.out.println(s));*/
        arr.stream().map(new Function<String, Object>() {
            @Override
            public Integer apply(String s) {
                String[] split = s.split("-");
                String s1 = split[1];
                return Integer.parseInt(s1);
            }
        }).forEach(s -> System.out.println(s));
    }
}
