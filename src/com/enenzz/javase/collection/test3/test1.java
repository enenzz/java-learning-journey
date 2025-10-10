package com.enenzz.javase.collection.test3;

import java.util.ArrayList;
import java.util.List;

public class test1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(1); //删除索引为1的元素
        list.remove(Integer.valueOf(1)); //删除值为1的元素
    }
}
