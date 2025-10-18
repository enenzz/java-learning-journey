package com.enenzz.javase.thread.test7;

public class MyThread extends Thread{
    static int count = 1000;

    @Override
    public void run() {
        while (true) {
            synchronized (MyThread.class) {
                if (count == 0) {
                    break;
                } else {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(getName() + "： 领取了一张，还剩" + --count + "张");
                }
            }
        }
    }
}
