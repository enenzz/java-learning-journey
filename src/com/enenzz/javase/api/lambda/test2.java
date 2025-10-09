package com.enenzz.javase.api.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class test2 {
    public static void main(String[] args) {
        String[] arr = {"hello111", "world1", "nice"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
