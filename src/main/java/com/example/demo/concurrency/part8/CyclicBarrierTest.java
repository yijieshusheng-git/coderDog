package com.example.demo.concurrency.part8;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName CyclicBarrierTest
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/8/27  7:47 上午
 * @Version 1.0
 */
public class CyclicBarrierTest {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        new Thread(() -> {
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(1);
        }).start();

        cyclicBarrier.await();
        System.out.println(2);
    }

}
