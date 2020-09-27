package com.example.demo.io.lubanzilu;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName ClientDemo
 * @Description 客户端 BIO
 * @Author 孤 鸿
 * @Date 2020/8/30  4:07 下午
 * @Version 1.0
 */
public class ClientDemo {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);
        Scanner scanner = new Scanner(System.in);
        System.out.println("等待输入: ");
        while (true){
            String next = scanner.next();
            socket.getOutputStream().write(next.getBytes());
        }

    }
}
