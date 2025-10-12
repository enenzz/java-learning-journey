package com.enenzz.javase.collection.test10;

public class test1 {
    public static void main(String[] args) {
        int sum = getSum(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println(sum);
    }

    public static int getSum(int... a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }

}
