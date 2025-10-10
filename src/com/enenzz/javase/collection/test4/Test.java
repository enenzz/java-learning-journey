package com.enenzz.javase.collection.test4;

public class Test {
    public static void main(String[] args) {
        MyArraysList<String> list = new MyArraysList<>();

        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        System.out.println(list);
    }
}
