package com.enenzz.javase.collection.test9;

import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeMap;

public class test1 {
    public static void main(String[] args) {
        String s = "aababcabcdabcde";
        TreeMap<Character, Integer> tm = new TreeMap<>();
        tm.put('a', 0);
        tm.put('b', 0);
        tm.put('c', 0);
        tm.put('d', 0);
        tm.put('e', 0);

        System.out.println(tm);

        Set<Map.Entry<Character, Integer>> entries = tm.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            int count = entry.getValue();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == entry.getKey()) {
                    count++;
                }
            }
            tm.put(entry.getKey(), count);
        }

        System.out.println(tm);

        StringBuilder sb = new StringBuilder();
        tm.forEach((key, value) -> sb.append(key).append("(").append(value).append(")"));
        System.out.println(sb);

        StringJoiner sj = new StringJoiner("", "", "");
        tm.forEach((key, value) -> sj.add(key + "").add("(").add(value + "").add(")"));
        System.out.println(sj);
    }
}
