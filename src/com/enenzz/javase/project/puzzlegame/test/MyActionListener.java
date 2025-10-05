package com.enenzz.javase.project.puzzlegame.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener extends JFrame implements ActionListener {
    JButton jb = new JButton("点我呀");

    public MyActionListener() {
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
        //取消默认居中
        setLayout(null);

        jb.setBounds(0, 0 , 100, 50);

        jb.addActionListener(this);

        getContentPane().add(jb);

        //显示窗口
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jb.setSize(200, 200);
    }
}
