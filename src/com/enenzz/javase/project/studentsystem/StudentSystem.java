package com.enenzz.javase.project.studentsystem;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class StudentSystem {
    public static void main(String[] args) {
        ArrayList<User> userArr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        User u = new User("it001", "123456", "123456789012345678", "12345678901");
        userArr.add(u);
//        printUser(userArr);

        loop:
        while (true) {
            System.out.println("---------------学生管理系统登录界面--------------");
            System.out.println("1：登录");
            System.out.println("2：注册");
            System.out.println("3：忘记密码");
            System.out.println("4: 查看账号信息");
            System.out.println("q: 退出");
            System.out.print("请输入您的选择: ");
            String choose = sc.next();
            System.out.println("---------------------------------------------");
            switch (choose) {
                case "1" -> login(userArr);
                case "2" -> register(userArr);
                case "3" -> forgetPassword(userArr);
                case "4" -> printUser(userArr);
                case "q" -> {
                    System.out.println("退出!");
                    break loop;
                }
                default -> System.out.println("输入错误,请重新输入!");
            }
        }


    }

    //登录
    public static void login(ArrayList<User> arr) {
        //用户名如果未注册，直接结束方法，并提示：用户名未注册，请先注册
        //判断验证码是否正确，如不正确，重新输入
        //再判断用户名和密码是否正确，有3次机会
        Scanner sc = new Scanner(System.in);

        //输入用户名
        System.out.println("请输入用户名:");
        String name = sc.next();
        if (!checkName(arr, name)) {
            System.out.println("用户名未注册,请先注册!");
            return;
        }


        int count = 3;
        while (count != 0) {
            //密码
            System.out.println("请输入密码");
            String password = sc.next();

            //验证码
            String vccode = vCode();
            System.out.println("验证码: " + vccode);
            System.out.println("请输入验证码:");
            String myvcode = sc.next();

            if (myvcode.equals(vccode) && checkCode(arr, name, password)) {
                menu();
                break;
            }

            count--;
            if (count == 0) {
                System.out.println("次数耗尽!");
            } else {
                System.out.println("验证码或密码错误,请重新输入");
                System.out.println("您还有" + count + "次机会!");
            }
        }
    }

    //注册
    public static void register(ArrayList<User> arr) {
        Scanner sc = new Scanner(System.in);

        //用户名输入
        String name;
        while (true) {
            System.out.println("请输入用户名:");
            name = sc.next();
            if (checkNameFormat(name)) {
                if (checkName(arr, name)) {
                    System.out.println("当前用户名已存在,请重新输入!");
                } else {
                    break;
                }
            } else {
                System.out.println("格式错误,请重新输入!");
            }
        }

        //俩次密码输入
        System.out.println("请输入密码:");
        String first = sc.next();
        while (true) {
            System.out.println("请输入相同的密码:");
            String second = sc.next();
            if (first.equals(second)) {
                break;
            }
            System.out.println("输入错误,请重新输入!");
        }

        //身份证号码输入
        String code;
        while (true) {
            System.out.println("请输入身份证号码:");
            code = sc.next();
            if (checkCodeFormat(code)) {
                break;
            }
            System.out.println("格式错误,请重新输入!");
        }

        //手机号码输入
        String phone;
        while (true) {
            System.out.println("请输入手机号码:");
            phone = sc.next();
            if (checkPhoneFormat(phone)) {
                break;
            }
            System.out.println("格式错误,请重新输入!");
        }

        User u = new User(name, first, code, phone);
        arr.add(u);
    }

    //忘记密码
    public static void forgetPassword(ArrayList<User> arr) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String name = sc.next();
        if (!checkName(arr, name)) {
            System.out.println("未注册");
            return;
        }

        while (true) {
            System.out.println("请输入身份证号码:");
            String code = sc.next();
            System.out.println("请输入手机号码:");
            String phone = sc.next();

            if (checkMessage(arr, name, code, phone)) {
                System.out.println("请输入新的密码:");
                String password = sc.next();
                while (true) {
                    System.out.println("请再次输入相同的密码");
                    String againPassword = sc.next();
                    if (password.equals(againPassword)){
                        break;
                    }
                    System.out.println("输入错误,请重新输入!");
                }
                setPassword(arr, name, password);
                System.out.println("密码修改成功!");
                break;
            }
            System.out.println("账号信息不匹配，修改失败");
            System.out.println("请重新输入!");
        }
    }

    //检测用户名是否唯一
    public static boolean checkName(ArrayList<User> arr, String name) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    //检测用户名格式是否正确
    public static boolean checkNameFormat(String name) {
        //用户名长度必须在3~15位之间
        //只能是字母加数字的组合，但是不能是纯数字
        if (name.length() < 3 || name.length() > 15) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z')) {
                count++;
            }
        }
        if (count == 0) {
            return false;
        }
        return true;
    }

    //检测身份证号格式是否正确
    public static boolean checkCodeFormat(String code) {
        //长度为18位
        //不能以0为开头
        //前17位，必须都是数字
        //最为一位可以是数字，也可以是大写X或小写x

        if (code.length() != 18) {
            return false;
        }

        //前17位必须为数字
        int count = 0;
        for (int i = 0; i < code.length() - 1; i++) {
            char num = code.charAt(i);
            if ('0' <= num && num <= '9') {
                count++;
            }
        }

        //最后一位
        boolean flag = true;
        char last = code.charAt(17);
        if (('0' <= last && last <= '9') || last == 'x' || last == 'X') {
            flag = false;
        }

        if (code.charAt(0) == 0 || count != 17 || flag) {
            return false;
        }

        return true;

    }

    //检测手机号码是否正确
    public static boolean checkPhoneFormat(String phone) {
        if (phone.length() != 11) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < phone.length(); i++) {
            char num = phone.charAt(i);
            if ('0' <= num && num <= '9') {
                count++;
            }
        }

        if (count != 11 || phone.charAt(0) == 0) {
            return false;
        }

        return true;
    }

    //检测用户名和密码是否匹配
    public static boolean checkCode(ArrayList<User> arr, String name, String password) {
        for (int i = 0; i < arr.size(); i++) {
            User s = arr.get(i);
            if (s.getName().equals(name)) {
                if (s.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    //生成验证码
    public static String vCode() {
        //包含a~z A~Z
        char[] c = new char[52];

        for (int i = 0; i < c.length; i++) {
            if (i < 26) {
                c[i] = (char) (65 + i);
            } else {
                c[i] = (char) (97 + i - 26);
            }
        }

        char[] result = new char[5];
        Random r = new Random();
        for (int i = 0; i < result.length - 1; i++) {
            result[i] = c[r.nextInt(52)];
        }
        result[result.length - 1] = (char) ('0' + r.nextInt(10));

        //打乱数组
        for (int i = 0; i < result.length; i++) {
            int num = r.nextInt(result.length);
            char temp = result[i];
            result[i] = result[num];
            result[num] = temp;
        }

        return new String(result);
    }

    //判断身份证与手机号是否与用户信息一致
    public static boolean checkMessage(ArrayList<User> arr, String name,String code, String phone) {
        for (int i = 0; i < arr.size(); i++) {
            User s = arr.get(i);
            if (s.getName().equals(name)) {
                if (s.getCode().equals(code) && s.getPhone().equals(phone)) {
                    return true;
                }
            }
        }
        return false;
    }

    //修改密码
    public static void setPassword(ArrayList<User> arr, String name,String password) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getName().equals(name)) {
                arr.get(i).setPassword(password);
            }
        }
    }

    //打印用户信息
    public static void printUser(ArrayList<User> arr) {
        for (int i = 0; i < arr.size(); i++) {
            User u = arr.get(i);
            System.out.println("用户名: " + u.getName());
            System.out.println("密码: " + u.getPassword());
            System.out.println("身份证: " + u.getCode());
            System.out.println("手机号: " + u.getPhone());

        }
    }

    //学生管理系统界面
    public static void menu() {
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
