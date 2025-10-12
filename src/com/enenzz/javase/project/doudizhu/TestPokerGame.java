package com.enenzz.javase.project.doudizhu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class TestPokerGame {
    static ArrayList<String> list = new ArrayList<>();
    static HashMap<String, Integer> hm = new HashMap<>();

    //定义初始化的牌序
    static {
        String[] color = {"♠", "♥", "♦", "♣"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        for (String c : color) {
            for (String n : number) {
                list.add(c + n);
            }
        }
        list.add(" 大王");
        list.add(" 小王");

        hm.put("J", 11);
        hm.put("Q", 12);
        hm.put("K", 13);
        hm.put("A", 14);
        hm.put("2", 15);
        hm.put("小王", 20);
        hm.put("大王", 30);
    }

    public TestPokerGame() {
        //洗牌
        Collections.shuffle(list);

        //发牌
        ArrayList<String> landlordPoker = new ArrayList<>();
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (i <= 2) {
                landlordPoker.add(list.get(i));
                continue;
            }
            if (i % 3 == 0) {
                player1.add(list.get(i));
            } else if (i % 3 == 1) {
                player2.add(list.get(i));
            } else {
                player3.add(list.get(i));
            }
        }

        sortPoker(landlordPoker);
        sortPoker(player1);
        sortPoker(player2);
        sortPoker(player3);


        //看牌
        lookPoker("地主", landlordPoker);
        lookPoker("zhangsan", player1);
        lookPoker("lishi", player2);
        lookPoker("wangwu", player3);
    }

    public void sortPoker(ArrayList<String> poker) {
        poker.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //用花色和牌的价值进行比较
                //o1花色和价值
                String color1 = o1.substring(0, 1);
                int value1 = countValue(o1);

                String color2 = o2.substring(0, 1);
                int value2 = countValue(o2);

                int i = value1 - value2;
                return i == 0 ? color1.compareTo(color2) : i;
            }
        });
    }

    public int countValue(String s) {
        //获取牌上数字
        String num = s.substring(1);
        if (hm.containsKey(num)) {
            return hm.get(num);
        } else {
            return Integer.parseInt(num);
        }
    }

    public void lookPoker(String name, ArrayList<String> list) {
        System.out.print(name + ": ");
        for (String card : list) {
            System.out.print(card + " ");
        }
        System.out.println();
    }
}
