package com.enenzz.javase.collection.test11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class test2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "男", "女", "男");

        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        Random r = new Random();
        int i = r.nextInt(arr.length);
        if (0 <= i && i <= 6) {
            System.out.println("男");
        } else {
            System.out.println("女");
        }

    }
}
