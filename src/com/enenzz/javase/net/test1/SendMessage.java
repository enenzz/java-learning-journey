package com.enenzz.javase.net.test1;

import java.io.IOException;
import java.net.*;
import java.net.InetAddress;
import java.util.Scanner;

public class SendMessage {
    public static void main(String[] args) throws IOException {
        //创建快递公司
        DatagramSocket ds = new DatagramSocket();

        //打包数据
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请输入您想说的话:");
            String str = sc.nextLine();
            if (str.equals("886")) {
                System.out.println("GoodBy!");
                break;
            }
            byte[] bytes = str.getBytes();
            InetAddress address = InetAddress.getByName("127.0.0.1");
            int port = 10086;
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);

            //发送数据
            ds.send(dp);
        }
        ds.close();
    }
}
