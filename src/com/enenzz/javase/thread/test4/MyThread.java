package com.enenzz.javase.thread.test4;

public class MyThread extends Thread {
    static int ticket = 0;
    static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (ticket < 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ticket++;
                    System.out.println(getName() + "卖了" + ticket + "张票了！");
                } else {
                    break;
                }
            }
        }
    }
}
