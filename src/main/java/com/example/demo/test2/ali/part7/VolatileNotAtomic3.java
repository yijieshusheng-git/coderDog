package com.example.demo.test2.ali.part7;

import java.util.concurrent.atomic.LongAdder;

/**
 * @ClassName VolatileNotAtomic3
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/29  9:12 下午
 * @Version 1.0
 */
public class VolatileNotAtomic3 {

    private static volatile LongAdder count = new LongAdder();
    private static final int NUMBER = 10000;

    //多次运行可以发现count并不是0，验证 volatile解决的是共享变量的可见性而不是原子性
    //第二种解决方式就是使的count++ 和count--操作变成原子性
    public static void main(String[] args) {
        Thread subtractThread = new SubtractThread();
        subtractThread.start();

        for (int i = 0; i < NUMBER; i++) {
            count.increment();
        }

        while (subtractThread.isAlive()) {
        }
        System.out.println(count);
    }

    private static class SubtractThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < NUMBER; i++) {
                count.decrement();
            }
        }
    }

}
