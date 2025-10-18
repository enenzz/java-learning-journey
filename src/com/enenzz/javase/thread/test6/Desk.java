package com.enenzz.javase.thread.test6;

public class Desk {
    //判断桌子上是否有面
    public static int food = 0;

    //可以吃10碗
    public static int count = 10;

    //定义锁对象
    public static Object lock = new Object();
}
