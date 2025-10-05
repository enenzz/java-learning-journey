package com.enenzz.javase.oop.test5;

public class Rabbit extends Animal {
    public Rabbit() {
    }

    public Rabbit(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("从胡萝卜");
    }
}
