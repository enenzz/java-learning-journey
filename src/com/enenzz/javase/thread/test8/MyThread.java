package com.enenzz.javase.thread.test8;

public class MyThread extends Thread{
    static int count = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (MyThread.class) {
                if (count < 10) {
                    break;
                } else {
                    System.out.println(getName() + "送出了一份礼物,还剩下" + --count + "份");
                }
            }
        }
    }
}
