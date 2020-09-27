package com.example.demo.concurrency.part8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ClassName SemaphoreTest
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/8/27  8:24 上午
 * @Version 1.0
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;

    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(() -> {

                try {
                    semaphore.acquire();
                    System.out.println("save data");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }

        threadPool.shutdown();
    }
}

