package com.example.demo.concurrency.part7;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName AtomicIntegerTest
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/8/26  10:23 下午
 * @Version 1.0
 */
public class AtomicIntegerTest {
    static AtomicInteger ai = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.get());
    }
}
