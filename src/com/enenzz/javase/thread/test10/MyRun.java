package com.enenzz.javase.thread.test10;

import java.util.Random;

public class MyRun implements Runnable {
    double money = 100;
    int count = 3;
    final double MIN = 0.01;

    @Override
    public void run() {
        synchronized (this) {
            if (count == 0) {
                System.out.println(Thread.currentThread().getName() + "没有抢到红包");
            } else {
                double price = 0;
                if (count == 1) {
                    price = money;
                } else {
                    // 99.8 0.01 0.01
                    Random r = new Random();
                    double bonds = money - (count - 1) * MIN;
                    price = r.nextDouble(bonds);
                    price = price < MIN ? MIN : price;
                }
                money -= price;
                count--;
                System.out.println(Thread.currentThread().getName() + "抢到了" + price + "元");
            }
        }
    }
}
