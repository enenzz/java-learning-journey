package com.enenzz.javase.function.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张三,23", "李四,24", "王五,25");
        Student[] array = list.stream()
                .map(Student::new)
                .toArray(Student[]::new);
        System.out.println(Arrays.toString(array));
    }
}
