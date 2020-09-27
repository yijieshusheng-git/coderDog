package com.example.demo.concurrency.part8;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName CyclicBarrierTest2
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/8/27  7:54 上午
 * @Version 1.0
 */
public class CyclicBarrierTest2 {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new A());

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

    static class A implements Runnable {

        @Override
        public void run() {
            System.out.println(3);
        }
    }
}
