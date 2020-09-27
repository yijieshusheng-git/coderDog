package com.example.demo.io.lubanzilu;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName ServerDemo
 * @Description BIO 演示 不考虑多线程，无法处理并发 服务端
 * @Author 孤 鸿
 * @Date 2020/8/30  3:51 下午
 * @Version 1.0
 */
public class ServerDemo {

    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[1024];
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(8080));

        while (true) {
            System.out.println("waiting connecting");
            //这里会阻塞一下，等待连接
            Socket socket = serverSocket.accept();

            System.out.println("connect success, start read data");
            //这里会阻塞一下，等待数据
            int readCount = socket.getInputStream().read(bytes);
            System.out.println("read data success");

            String result = new String(bytes);
            System.out.println("readCount: " + readCount + ",result: " + result);
        }

    }

}
