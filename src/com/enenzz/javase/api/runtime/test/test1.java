package com.enenzz.javase.api.runtime.test;

import java.io.IOException;

public class test1 {
    public static void main(String[] args) throws IOException {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);
        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);
        System.out.println(Runtime.getRuntime().freeMemory()/1024/1024);
        Runtime.getRuntime().exec("shutdown -a");
    }
}
