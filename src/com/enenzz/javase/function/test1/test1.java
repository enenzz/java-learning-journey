package com.enenzz.javase.function.test1;

import java.util.ArrayList;
import java.util.Collections;

public class test1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "1", "2", "3", "4");
        list.stream().map(Integer::parseInt).forEach(s -> System.out.println(s));
    }
}
