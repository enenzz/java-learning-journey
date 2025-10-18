package com.enenzz.javase.thread.test6;

public class Cook extends Thread{

    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lock) {
                if (Desk.count == 0) {
                    break;
                } else {
                    if (Desk.food == 1) {
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        Desk.food = 1;
                        System.out.println("厨师做了一碗面条");
                        Desk.lock.notifyAll();
                    }
                }
            }
        }
    }
}
