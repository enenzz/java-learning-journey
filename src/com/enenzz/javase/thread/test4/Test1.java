package com.enenzz.javase.thread.test4;

public class Test1 {
    public static void main(String[] args) {
        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();
        MyThread mt3 = new MyThread();
        mt1.setName("窗口1 ");
        mt2.setName("窗口2 ");
        mt3.setName("窗口3 ");
        mt1.start();
        mt2.start();
        mt3.start();
    }
}
