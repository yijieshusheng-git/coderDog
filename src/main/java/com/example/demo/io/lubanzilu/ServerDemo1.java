package com.example.demo.io.lubanzilu;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ServerDemo1
 * @Description NIO 服务端
 * @Author 孤 鸿
 * @Date 2020/8/31  4:49 下午
 * @Version 1.0
 */
public class ServerDemo1 {

    private static List<SocketChannel> list = new ArrayList<>();
    private static ByteBuffer byteBuffer = ByteBuffer.allocate(512);

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);

        while (true){
            SocketChannel socketChannel = serverSocketChannel.accept();
            if(socketChannel == null){
                Thread.sleep(1000);
                System.out.println("没人连接");
            }else{
                System.out.println("已连接------------------------------------------");
                socketChannel.configureBlocking(false);
                list.add(socketChannel);
            }

            list.forEach(client->{
                try {
                    int read = client.read(byteBuffer);
                    if(read > 0){
                        byteBuffer.flip();
                        System.out.println(StandardCharsets.UTF_8.decode(byteBuffer).toString());
                        byteBuffer.clear();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

    }

}
