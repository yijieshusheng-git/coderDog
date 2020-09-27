package com.example.demo.concurrency.part8;

/**
 * @ClassName JoinCountDownLatchTest
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/8/26  10:46 下午
 * @Version 1.0
 */
public class JoinCountDownLatchTest {

    public static void main(String[] args) throws Exception{
        Thread thread1 = new Thread(()-> System.out.println("parser 1 finish"));
        Thread thread2 = new Thread(()-> System.out.println("parser 2 finish"));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("all finish");
    }

}
