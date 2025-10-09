package com.enenzz.javase.collection.test2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class test1 {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();

        coll.add("aaa");
        coll.add("bbb");
        coll.add("ccc");

        //创建集合指针
        Iterator<String> point = coll.iterator();
        while(point.hasNext()) {
            System.out.println(point.next());
        }

    }
}
