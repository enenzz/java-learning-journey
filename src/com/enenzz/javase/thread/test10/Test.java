package com.enenzz.javase.thread.test10;

import com.enenzz.javase.thread.test10.MyRun;

public class Test {
    public static void main(String[] args) {
        MyRun mr = new MyRun();
        Thread t1 = new Thread(mr, "张三");
        Thread t2 = new Thread(mr, "李四");
        Thread t3 = new Thread(mr, "王五");
        Thread t4 = new Thread(mr, "赵六");
        Thread t5 = new Thread(mr, "老七");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
