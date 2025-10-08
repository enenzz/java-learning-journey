package com.enenzz.javase.api.object.test;

public class test1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] brr = new int[5];
        brr = arr;
        for (int i = 0; i < brr.length; i++) {
            System.out.println(brr[i]);
        }
    }
}

