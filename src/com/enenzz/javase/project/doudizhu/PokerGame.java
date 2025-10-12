package com.enenzz.javase.project.doudizhu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class PokerGame {
    static HashMap<Integer, String> hm = new HashMap<>();
    static ArrayList<Integer> arr = new ArrayList<>();

    static {
        String[] color = {"♦", "♣", "♠", "♥"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        //记录牌的序号
        int code = 1;
        for (String n : number) {
            for (String c : color) {
                hm.put(code, c + n);
                arr.add(code++);
            }
        }
        arr.add(code);
        hm.put(code++, "大王");
        arr.add(code);
        hm.put(code, "小王");
    }

    public PokerGame() {
        //洗牌
        Collections.shuffle(arr);

        //发票
        TreeSet<Integer> landlordPoker = new TreeSet<>();
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();

        for (int i = 0; i < arr.size(); i++) {
            if (i <= 2) {
                landlordPoker.add(arr.get(i));
                continue;
            }
            if (i % 3 == 0) {
                player1.add(arr.get(i));
            } else if (i % 3 == 1) {
                player2.add(arr.get(i));
            } else {
                player3.add(arr.get(i));
            }
        }

        //看牌
        lookPoker("dizhu", landlordPoker);
        lookPoker("zhangsan", player1);
        lookPoker("lishi", player2);
        lookPoker("wangwu", player3);
    }

    public void lookPoker(String name, TreeSet<Integer> ts) {
        System.out.print(name + ": ");
        for (int t : ts) {
            System.out.print(t + " ");
        }
        System.out.println();
    }
}
