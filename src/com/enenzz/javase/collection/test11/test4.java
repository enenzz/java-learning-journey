package com.enenzz.javase.collection.test11;

import java.util.HashMap;

public class test4 {
    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<>();

        hm.put("江苏省", "南京市");
        hm.put("湖北省", "武汉市");
        hm.put("河北省", "石家庄市");
        System.out.println(hm);
    }
}
