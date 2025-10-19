package com.enenzz.javase.net.test1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiveMessage {
    public static void main(String[] args) throws IOException {
        //创建快递公司
        DatagramSocket ds = new DatagramSocket(10086);

        //接受数据
        byte[] bytes = new  byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

        while (true) {
            ds.receive(dp);

            //解析数据
            byte[] data = dp.getData();
            int len = dp.getLength();
            System.out.println(new String(data, 0, len));

        }
    }
}
