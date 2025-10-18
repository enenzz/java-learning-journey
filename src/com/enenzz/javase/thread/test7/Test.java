package com.enenzz.javase.thread.test7;

public class Test {
    public static void main(String[] args) {
        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();

        mt1.setName("窗口1");
        mt2.setName("窗口2");

        mt1.start();
        mt2.start();
    }
}
