package com.enenzz.javase.exception.test1;

public class test1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        try{
            System.out.println(arr[10]);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
