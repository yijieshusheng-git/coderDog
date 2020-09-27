package com.example.demo.concurrency.part8;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @ClassName BankWaterService
 * @Description 模拟银行流水计算  多线程并发执行
 * @Author 孤 鸿
 * @Date 2020/8/27  8:00 上午
 * @Version 1.0
 */
public class BankWaterService implements Runnable {

    public static final int COUNT = 4;
    /**
    *  创建四个屏障
    */
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(COUNT, this);
    /**
     *  创建四个线程
     */
    private Executor executor = Executors.newFixedThreadPool(COUNT);

    private ConcurrentHashMap<String, Integer> sheet = new ConcurrentHashMap<>();

    private void count() {
        for (int i = 0; i < COUNT; i++) {
            executor.execute(() -> {
                sheet.put(Thread.currentThread().getName(), 100);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
        for (Map.Entry<String, Integer> entry : sheet.entrySet()) {
            result += entry.getValue();
        }
        sheet.put("result", result);
        System.out.println("result: " + result);
    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }

}
