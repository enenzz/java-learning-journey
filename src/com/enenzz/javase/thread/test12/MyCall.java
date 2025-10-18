package com.enenzz.javase.thread.test12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;

public class MyCall implements Callable<Integer> {

    ArrayList<Integer> list = new ArrayList<>();
    public MyCall(){
        Collections.addAll(list, 10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700);
    }

    @Override
    public Integer call() throws Exception {
        ArrayList<Integer> box = new ArrayList<>();
        while (true) {
            synchronized (this) {
                if (list.size() == 0) {
                    System.out.println(Thread.currentThread().getName()+":" + box);
                    break;
                } else {
                    Collections.shuffle(list);
                    int money = list.remove(0);
                    box.add(money);
                }
            }
            Thread.sleep(10);
        }
        if (box.size() == 0) {
            return null;
        } else {
            return Collections.max(box);
        }
    }
}
