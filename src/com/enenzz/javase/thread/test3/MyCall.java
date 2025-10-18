package com.enenzz.javase.thread.test3;

import java.util.concurrent.Callable;

public class MyCall implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}
