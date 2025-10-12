package com.enenzz.javase.collection.test8;

import java.util.Objects;

public class Student implements Comparable{
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return  name + "," + age;
    }

    @Override
    public int compareTo(Object o) {
        Student s = (Student) o;
        int i = this.getAge() - s.getAge();
        i = i == 0? this.getName().compareTo(s.getName()) : i;
        return i;
    }
}
