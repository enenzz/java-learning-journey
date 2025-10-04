package com.enenzz.javase.project.studentsystem;

public class User {
    // 属性：用户名、密码、身份证号码、手机号码
    private String name;
    private String password;
    private String code;
    private String phone;

    public User() {
    }

    public User(String name, String password, String code, String phone) {
        this.name = name;
        this.password = password;
        this.code = code;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
