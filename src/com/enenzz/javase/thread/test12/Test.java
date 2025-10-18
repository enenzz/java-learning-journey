package com.enenzz.javase.thread.test12;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCall mc = new MyCall();

        FutureTask<Integer> f1 = new FutureTask<>(mc);
        FutureTask<Integer> f2 = new FutureTask<>(mc);

        Thread t1 = new Thread(f1, "抽奖箱1");
        Thread t2 = new Thread(f2, "抽奖箱2");

        t1.start();
        t2.start();

        System.out.println(f1.get());
        System.out.println(f2.get());
    }
}
