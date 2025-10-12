package com.enenzz.javase.collection.test11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class test3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        Collections.addAll(list, "zhangsan", "lisi", "wangwu", "laoliu");
        Random r = new Random();
        while (list.size() != 0){
            int index = r.nextInt(list.size());
            System.out.println(list.get(index));
            list.remove(index);
        }
    }

    public static void fun(ArrayList<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }
}
