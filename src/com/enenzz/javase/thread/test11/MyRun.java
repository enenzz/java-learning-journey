package com.enenzz.javase.thread.test11;

import java.util.ArrayList;
import java.util.Collections;

public class MyRun implements Runnable {
    ArrayList<Integer> list = new ArrayList<>();
    public MyRun(){
        Collections.addAll(list, 10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700);
    }

    @Override
    public void run() {
        ArrayList<Integer> box = new ArrayList<>();
        while (true) {
            synchronized (this) {
                if (list.size() == 0) {
                    if (Thread.currentThread().getName().equals("抽奖箱1")) {
                        printList(box);
                    } else {
                        printList(box);
                    }
                    break;
                } else {
                    Collections.shuffle(list);
                    int money = list.remove(0);
                    box.add(money);
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void printList(ArrayList<Integer> list) {
        int sum = 0;
        int max = list.get(0);
        if (Thread.currentThread().getName().equals("抽奖箱1")) {
            System.out.println("抽奖箱1:");
        } else {
            System.out.println("抽奖箱2:");
        }
        for (int i = 0; i < list.size(); i++) {
            if (max < list.get(i)) {
                max = list.get(i);
            }
            sum += list.get(i);
            System.out.print(list.get(i) + ",");
        }

        System.out.print("最高奖项为" + max + "元,");
        System.out.println("总金额为" + sum + "元");
    }
}
