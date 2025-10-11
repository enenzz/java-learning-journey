package com.enenzz.javase.collection.test6;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class test3 {
    public static void main(String[] args) {
        //通过entry遍历
        Map<String, String> mp =new HashMap<>();

        mp.put("zhangsan", "lan");
        mp.put("lisi", "xiao");
        mp.put("wangwu", "niu");

        mp.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {
                System.out.println(key + "=" + value);
            }
        });

        mp.forEach((key, value) -> System.out.println(key + "=" + value));
    }
}
