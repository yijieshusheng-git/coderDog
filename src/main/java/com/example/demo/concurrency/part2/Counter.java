package com.example.demo.concurrency.part2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName Counter
 * @Description 基于CAS线程安全的计数器方法safeCount和一个非线程安全的计数器count
 * @Author 孤 鸿
 * @Date 2020/8/6  7:58 下午
 * @Version 1.0
 */
public class Counter {

    private AtomicInteger atomicI = new AtomicInteger(0);
    private int i = 0;

    public static void main(String[] args) {
        final Counter cas = new Counter();
        List<Thread> ts = new ArrayList<>(600);
        long start = System.currentTimeMillis();

        for (int j = 0; j < 100; j++) {
            Thread t = new Thread(() -> {
                for (int k = 0; k < 10000; k++) {
                    cas.count();
                    cas.safeCount();
                }
            });
            ts.add(t);
        }

        for (Thread t : ts) {
            t.start();
        }

        for (Thread t : ts) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(cas.i);
        System.out.println(cas.atomicI.get());
        System.out.println(System.currentTimeMillis() - start);

    }

    private void safeCount() {
        for (; ; ) {
            int j = atomicI.get();
            boolean result = atomicI.compareAndSet(i, ++i);
            if (result) {
                break;
            }
        }
    }

    private void count() {
        i++;
    }
}
