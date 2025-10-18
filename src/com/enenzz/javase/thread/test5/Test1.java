package com.enenzz.javase.thread.test5;

public class Test1 {
    public static void main(String[] args) {
        MyRun mr = new MyRun();
        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);
        Thread t3 = new Thread(mr);

        t1.setName("窗口1 ");
        t2.setName("窗口2 ");
        t3.setName("窗口3 ");

        t1.start();
        t2.start();
        t3.start();
    }
}
