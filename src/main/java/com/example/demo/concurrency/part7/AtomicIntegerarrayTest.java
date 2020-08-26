package com.example.demo.concurrency.part7;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @ClassName AtomicIntegerarrayTest
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/8/26  10:24 下午
 * @Version 1.0
 */
public class AtomicIntegerarrayTest {
    static int[] value = new int[]{1, 2};
    static AtomicIntegerArray ai = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        ai.getAndSet(0, 3);
        System.out.println(ai.get(0));
        System.out.println(value[0]);
    }
}
