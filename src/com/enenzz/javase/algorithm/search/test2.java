package com.enenzz.javase.algorithm.search;

public class test2 {
    public static void main(String[] args) {
        //二分查找
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int find = binarySearch(arr, 9);
        System.out.println(find);

    }

    public static int binarySearch(int[] arr, int num) {
        int min = 0;
        int max = arr.length - 1;
        int mid = 0;
        while (min <= max) {
            mid = (max + min) / 2;
            if (arr[mid] > num) {
                max = mid - 1;
            } else if (arr[mid] < num) {
                min = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
