package com.enenzz.javase.thread.test3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //任务
        MyCall mc = new MyCall();
        //管理多线程的结果
        FutureTask<Integer> ft = new FutureTask<>(mc);

        Thread t = new Thread(ft);
        t.start();
        System.out.println(ft.get());
    }
}
