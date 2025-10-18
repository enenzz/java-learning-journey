package com.enenzz.javase.thread.test2;

public class Test1 {
    public static void main(String[] args) {
        MyRun run = new MyRun();
        Thread t = new Thread(run);
        t.start();
    }
}
