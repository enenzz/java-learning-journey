package com.enenzz.javase.collection.test;

import java.util.ArrayList;

public class Test2 {
    public static void main(String[] args) {
        /*需求:1，main方法中定义一个集合，存入三个用户对象。
        用户属性为:id，username，password，
        要求:定义一个方法，根据id查找对应的用户信息如果存在，
        返回true如果不存在，返回false*/

        ArrayList<User> arr = new ArrayList<>();

        User u1 = new User("123", "zhangsan", "qwe");
        User u2 = new User("456", "lisi", "asd");
        User u3 = new User("789", "wangwu", "zxc");

        arr.add(u1);
        arr.add(u2);
        arr.add(u3);

        System.out.println(check(arr, "123"));
    }

    public static boolean check(ArrayList<User> arr, String id) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getId().equals(id)) {
                return true;
            }
        }
        return false;
    }



}
