package com.enenzz.javase.project.puzzlegame.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

//游戏界面
public class GameJFrame extends JFrame implements KeyListener {
    int[][] data = new int[4][4];
    int x, y;
    String path = "puzzlegame_image\\animal\\animal3\\";

    public GameJFrame() {
        //初始窗口
        initJFrame();

        //初始化菜单
        initJMenuBar();

        //初始化数据
        initData();

        //初始化图片
        initImage();

        //窗口可见
        setVisible(true);
    }

    private void initData() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //打乱数组
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int index = r.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                x = i / 4;
                y = i % 4;
            } else {
                data[i / 4][i % 4] = arr[i];
            }
        }
    }

    private void initImage() {
        //清楚当前界面
        getContentPane().removeAll();

        //重新创建画面
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = data[i][j];
                //当num=16时没有图片次数 也会生成容器但是是空的
                JLabel jl = new JLabel(new ImageIcon(path + num + ".jpg "));
                //指定图片位置
                jl.setBounds(105 * j + 84, 105 * i + 134, 105, 105);
                //把容器添加到界面
                jl.setBorder(new BevelBorder(1));
                getContentPane().add(jl);
                num++;
            }
        }
        //背景
        JLabel jlBackground = new JLabel(new ImageIcon("puzzlegame_image\\background.png"));
        jlBackground.setBounds(40, 40, 508, 560);
        getContentPane().add(jlBackground);

        //刷新界面
        getContentPane().repaint();
    }

    private void initJFrame() {
        //窗口大小
        setSize(603, 680);
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
        //添加键盘事件
        addKeyListener(this);
    }

    private void initJMenuBar() {
        //整个菜单对象
        JMenuBar jb = new JMenuBar();

        //菜单上俩个选项
        JMenu jTools = new JMenu("功能");
        JMenu jAbout = new JMenu("关于我们");

        //下拉列表
        JMenuItem replayGame = new JMenuItem("重新游戏");
        JMenuItem reLogin = new JMenuItem("重新登录");
        JMenuItem closeGame = new JMenuItem("关闭游戏");
        jTools.add(replayGame);
        jTools.add(reLogin);
        jTools.add(closeGame);

        JMenuItem call = new JMenuItem("公众号");
        jAbout.add(call);

        jb.add(jTools);
        jb.add(jAbout);

        setJMenuBar(jb);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {
            //清空所有图片
            getContentPane().removeAll();

            //加载图片
            JLabel jl = new JLabel(new ImageIcon(path + "all.jpg"));
            jl.setBounds(84, 134, 420, 420);
            getContentPane().add(jl);

            //背景
            JLabel jlBackground = new JLabel(new ImageIcon("puzzlegame_image\\background.png"));
            jlBackground.setBounds(40, 40, 508, 560);
            getContentPane().add(jlBackground);

            //刷新图片
            getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        //空图的坐标为x, y
        if (code == 37) {
            //左
            if (y == 3) {
                return;
            }
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            initImage();
        } else if (code == 38) {
            //上
            if (x == 3) {
                return;
            }
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            initImage();
        } else if (code == 39) {
            //右
            if (y == 0) {
                return;
            }
            data[x][y] = data[x][y - 1];
            data[x ][y - 1] = 0;
            y--;
            initImage();
        } else if (code == 40) {
            //下
            if (x == 0) {
                return;
            }
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            initImage();
        } else if (code == 65) {
            initImage();
        }
    }
}
