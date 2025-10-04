package com.enenzz.javase.oop.test3;

public class AdminStaff extends Employee {
    public AdminStaff() {
    }

    public AdminStaff(String id, String name) {
        super(id, name);
    }

    @Override
    public void work() {
        System.out.println("管理");
    }
}
