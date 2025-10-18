package com.enenzz.javase.thread.test9;

public class MyRun implements Runnable {
    int num = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (num > 100) {
                    break;
                } else {
                    if (num % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + ": " + num);
                    }
                    num++;
                }
            }
        }
    }
}
