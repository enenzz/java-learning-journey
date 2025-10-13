package com.enenzz.javase.Stream.test;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class test4 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("zhangsan, 23");
        list.add("lisi, 24");
        list.add("wangwu, 25");

        Map<String, Integer> newList = list.stream()
                .filter(s -> Integer.parseInt(s.split(", ")[1]) >= 24)
                .collect(Collectors.toMap(
                        s -> s.split(", ")[0],
                        s -> Integer.parseInt(s.split(", ")[1]
                        )));

        System.out.println(newList);
    }
}
