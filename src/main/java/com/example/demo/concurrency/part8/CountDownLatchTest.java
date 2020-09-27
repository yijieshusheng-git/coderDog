package com.example.demo.concurrency.part8;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName CountDownLatchTest
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/8/26  10:50 下午
 * @Version 1.0
 */
public class CountDownLatchTest {

    static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            System.out.println(1);
            countDownLatch.countDown();
            System.out.println(2);
            countDownLatch.countDown();
        }).start();

        countDownLatch.await();
        System.out.println(3);
    }

}
