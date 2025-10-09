package com.enenzz.javase.api.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class test1 {
    public static void main(String[] args) {
        Integer[] arr = {1, 3, 5, 2, 6, 4, 8, 7};
        Arrays.sort(arr, (o1, o2) -> o1 - o2);
        System.out.println(Arrays.toString(arr));
    }
}
