package com.enenzz.javase.api.regex.test;

public class test3 {
    public static void main(String[] args) {
        //aaa123aaa
        String regex1 = "((.\\2*)).+\\1";
        System.out.println("aaa123aaa".matches(regex1));
    }
}
