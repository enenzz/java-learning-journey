package com.enenzz.javase.thread.test8;

public class Test {
    public static void main(String[] args) {
        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();

        mt1.setName("张三");
        mt2.setName("李四");

        mt1.start();
        mt2.start();
    }
}
