package com.enenzz.javase.oop.test3;

public class TestDemo {
    public static void main(String[] args) {
        Lecturer lt = new Lecturer("it001", "qwe");
        System.out.println(lt.getId() + lt.getName());
        lt.work();

    }
}
