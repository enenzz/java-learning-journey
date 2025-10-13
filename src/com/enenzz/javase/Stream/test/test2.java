package com.enenzz.javase.Stream.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class test2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "zhangsan-14", "lishi-15", "wangwu-16");

/*
        Map<String, Integer> mp = list.stream().collect(Collectors.toMap(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.split("-")[0];
            }
        }, new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s.split("-")[1]);
            }
        }));
*/
        Map<String, Integer> mp = list.stream().collect(Collectors.toMap(s -> s.split("-")[0],
                s -> Integer.parseInt(s.split("-")[1])));

        System.out.println(mp);
    }
}
