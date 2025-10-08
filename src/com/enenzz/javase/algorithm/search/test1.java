package com.enenzz.javase.algorithm.search;

import java.util.ArrayList;

public class test1 {
    public static void main(String[] args) {
        //基本查找
        int[] arr = {8, 8, 3, 4, 5, 6, 7, 8, 8};
        ArrayList<Integer> list = findIndex(arr, 8);
        System.out.println(list);
    }

    public static ArrayList<Integer> findIndex(int[] arr, int num) {
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                list.add(i);
            }
        }
        return list;
    }
}
