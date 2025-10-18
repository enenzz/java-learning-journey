package com.enenzz.javase.thread.test6;

public class Foodie extends Thread {

    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lock) {
                if (Desk.count == 0) {
                    //吃饱了
                    break;
                } else {
                    if (Desk.food == 0) {
                        //桌子上没有面
                        //没有面就要等待
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        //桌子上有面
                        System.out.println("吃货正在吃面，还可以吃" + --Desk.count + "碗面");
                        //修改桌子状态
                        Desk.food = 0;
                        //唤醒厨师做面
                        Desk.lock.notifyAll();

                    }
                }
            }
        }
    }
}
