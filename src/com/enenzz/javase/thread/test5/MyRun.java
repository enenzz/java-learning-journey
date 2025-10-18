package com.enenzz.javase.thread.test5;

public class MyRun implements Runnable{
    int ticket = 0;
    
    @Override
    public void run() {
        while (true) {
                if (temp()) break;
        }
    }

    private synchronized boolean temp() {
        if (ticket < 100) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ticket++;
            System.out.println(Thread.currentThread().getName() + "卖了" + ticket + "张票了！");
            return false;
        }
        return true;
    }
}
