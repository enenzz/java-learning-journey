package com.enenzz.javase.project.studentsystem;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class StudentSystem {
    public static void start() {
        ArrayList<Student> stuArr = new ArrayList<>();
        loop:
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("-----------------学生管理系统------------------");
            System.out.println("1：添加学生");
            System.out.println("2：删除学生");
            System.out.println("3：修改学生");
            System.out.println("4：查询学生");
            System.out.println("q：退出");
            System.out.print("请输入您的选择: ");
            String choose = sc.next();
            System.out.println("---------------------------------------------");
            switch (choose) {
                case "1" -> addStudent(stuArr);
                case "2" -> deleteStudent(stuArr);
                case "3" -> setStudent(stuArr);
                case "4" -> getStudent(stuArr);
                case "q" -> {
                    System.out.println("退出!");
                    break loop;
//                    System.exit(0);
                }
                default -> System.out.println("输入错误,请重新输入!");
            }
        }
    }

    //增
    public static void addStudent(ArrayList<Student> arr) {
        Scanner sc = new Scanner(System.in);

        //id唯一
        String id;
        while (true) {
            System.out.println("请输入学生id:");
            id = sc.next();
            boolean flag = checkId(arr, id);
            if (flag) {
                // id存在 请重新输入
                System.out.println("id存在,请重新输入!");
            } else {
                break;
            }
        }

        System.out.println("请输入学生姓名:");
        String name = sc.next();
        System.out.println("请输入学生年龄:");
        int age = sc.nextInt();
        System.out.println("请输入学生住址:");
        String address = sc.next();

        Student stu = new Student(id, name, age, address);
        arr.add(stu);
        System.out.println("添加成功!");
    }

    //删
    public static void deleteStudent(ArrayList<Student> arr) {
        //id存在删除
        //id不存在，需要提示不存在，并回到初始菜单
        //获取id的索引,返回-1则不存在
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入要删除学生的id:");
        String id = sc.next();

        //获取id对应的索引
        int index = getIndex(arr, id);
        if (index == -1) {
            //id不存在
            System.out.println("输入的id不存在!");
            return;
        }

        arr.remove(index);
        System.out.println("删除成功!");

    }

    //改
    public static void setStudent(ArrayList<Student> arr) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改学生的id:");
        String id = sc.next();
        int index = getIndex(arr, id);
        if (index == -1) {
            System.out.println("输入的学生id不存在!");
            return;
        }

        System.out.println("请输入学生的id:");
        String newId = sc.next();
        System.out.println("请输入学生姓名:");
        String newName = sc.next();
        System.out.println("请输入学生年龄:");
        int newAge = sc.nextInt();
        System.out.println("请输入学生住址:");
        String newAddress = sc.next();

        Student stu = new Student(newId, newName, newAge, newAddress);
        arr.set(index, stu);
        System.out.println("修改成功!");
    }

    //查
    public static void getStudent(ArrayList<Student> arr) {
        if (arr.size() == 0) {
            System.out.println("当前无学生信息，请添加后再查询!");
            return;
        }

        System.out.println("id\t姓名\t年龄\t家庭住宅");
        for (int i = 0; i < arr.size(); i++) {
            Student str = arr.get(i);
            System.out.println(str.getId() + "\t" + str.getName() + "\t" + str.getAge() + "\t" + str.getAddress());
        }
    }

    public static boolean checkId(ArrayList<Student> arr, String id) {
        //检测id是否存在
        return getIndex(arr, id) >= 0;
    }

    public static int getIndex(ArrayList<Student> arr, String id) {
        //通过id获取索引
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
