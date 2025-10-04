package com.enenzz.javase.oop.test3;

public class Teacher extends Employee {
    public Teacher() {
    }

    public Teacher(String id, String name) {
        super(id, name);
    }

    @Override
    public void work() {
        System.out.println("教学");
    }
}
