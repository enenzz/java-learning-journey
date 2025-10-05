package com.enenzz.javase.project.puzzlegame.ui;

import javax.swing.*;

//登录界面
public class LoginJFrame extends JFrame {
    public LoginJFrame() {
        //窗口大小
        setSize(600, 600);
        //窗口标题
        setTitle("拼图 v1.0");
        //窗口置于顶层
        setAlwaysOnTop(true);
        //窗口居中
        setLocationRelativeTo(null);
        //关闭模式为3
        setDefaultCloseOperation(3);
        //窗口可见
        setVisible(true);
    }
}
