package com.enenzz.javase.collection.test11;

import java.util.ArrayList;
import java.util.Collections;

public class test1 {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        Collections.addAll(arr, "zhangsan", "lishi", "wangwu");
        Collections.shuffle(arr);
        System.out.println(arr.get(0));
    }

}
