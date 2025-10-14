package com.enenzz.javase.exception.test2;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name;
        int age;
        while (true) {
            try {
                name = sc.nextLine();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            age = sc.nextInt();
        }



    }
}
