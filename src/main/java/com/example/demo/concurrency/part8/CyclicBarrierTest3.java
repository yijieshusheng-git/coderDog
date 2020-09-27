package com.example.demo.concurrency.part8;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName CyclicBarrierTest3
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/8/27  8:15 上午
 * @Version 1.0
 */
public class CyclicBarrierTest3 {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        thread.interrupt();

        try {
            cyclicBarrier.await();
        } catch (Exception e) {
            System.out.println(cyclicBarrier.isBroken());
        }
    }
}
