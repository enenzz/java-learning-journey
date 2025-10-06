package com.enenzz.javase.api.math.test;

public class test1 {
    //找质数
    public static void main(String[] args) {
        System.out.println(isPrime(3));
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
