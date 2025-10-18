package com.enenzz.javase.thread.test6;

public class Test {
    public static void main(String[] args) {
        Cook c = new Cook();
        Foodie f = new Foodie();

        c.start();
        f.start();
    }
}
