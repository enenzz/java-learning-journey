package com.enenzz.javase.collection.test6;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class test1 {
    public static void main(String[] args) {
        Map<String, String> mp = new HashMap<>();

        mp.put("zhangsan", "lan");
        mp.put("lisi", "xiao");
        mp.put("wangwu", "niu");

        System.out.println(mp);

        //将键放入串中
        Set<String> keys = mp.keySet();
        for (String key : keys) {
            System.out.println(mp.get(key));
        }

        //迭代器
        Iterator<String> it = mp.keySet().iterator();
        while (it.hasNext()){
            System.out.println(mp.get(it.next()));
        }

        //lambda
        keys.forEach(key -> System.out.println(mp.get(key)));
    }
}
