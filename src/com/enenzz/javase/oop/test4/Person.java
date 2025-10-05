package com.enenzz.javase.oop.test4;

public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
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

    //行为
    public void keepPet(Animal a, String something) {
        if (a instanceof Dog d) {
            System.out.println("年龄为" + getAge() + "的"+ getName() + "养了一只"+ d.getColor() +"颜色的"+ d.getAge() +"岁的狗");
            a.eat(something);
        } else if (a instanceof Cat c) {
            System.out.println("年龄为" + getAge() + "的"+ getName() + "养了一只"+ c.getColor() +"颜色的"+ c.getAge() +"岁的猫");
            a.eat(something);
        }

    }
}
