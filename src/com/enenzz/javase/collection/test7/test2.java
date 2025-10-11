package com.enenzz.javase.collection.test7;

import java.util.*;

public class test2 {
    public static void main(String[] args) {
        Random r = new Random();
        String[] s = {"A", "B", "C", "D"};
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < 80; i++) {
            String option = s[r.nextInt(s.length)];
            arr.add(option);
        }

        HashMap<String, Integer> hm = new HashMap<>();
        for (String name : arr) {
            if (hm.containsKey(name)) {
                int count = hm.get(name);
                count++;
                hm.put(name, count);
            }else {
                hm.put(name, 1);
            }
        }
        System.out.println(hm);

        //求最大值
        int max = 0;
        Set<Map.Entry<String, Integer>> entries = hm.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            int count = entry.getValue();
            if (count > max) {
                max = count;
            }
        }
        System.out.println(max);
        //若最大值有多个
        for (Map.Entry<String, Integer> entry : entries) {
            int count = entry.getValue();
            if (count == max) {
                System.out.println(entry.getKey());
            }
        }
    }
}
