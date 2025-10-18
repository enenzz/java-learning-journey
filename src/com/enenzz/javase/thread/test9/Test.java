package com.enenzz.javase.thread.test9;

public class Test {
    public static void main(String[] args) {
        MyRun mr = new MyRun();
        Thread t1 = new Thread(mr, "张三");
        Thread t2 = new Thread(mr, "李四");

        t1.start();
        t2.start();
    }
}
