package com.enenzz.javase.thread.test11;

public class Test {
    public static void main(String[] args) {
        MyRun mr = new MyRun();
        Thread t1 = new Thread(mr, "抽奖箱1");
        Thread t2 = new Thread(mr, "抽奖箱2");
        t1.start();
        t2.start();

    }
}
