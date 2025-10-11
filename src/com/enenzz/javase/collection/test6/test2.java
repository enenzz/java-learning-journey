package com.enenzz.javase.collection.test6;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class test2 {
    public static void main(String[] args) {
        //通过entry遍历
        Map<String, String> mp =new HashMap<>();

        mp.put("zhangsan", "lan");
        mp.put("lisi", "xiao");
        mp.put("wangwu", "niu");

        System.out.println(mp);

        //增强for
        Set<Map.Entry<String, String>> entries = mp.entrySet();
        for(Map.Entry<String, String> entry : entries) {
            System.out.println(entry);
        }

        //迭代器
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //lambda
        entries.forEach(k -> System.out.println(k));
    }
}
