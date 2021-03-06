package com.example.demo.test2.ali.part7;

/**
 * @ClassName VolatileNotAtomic2
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/29  9:10 下午
 * @Version 1.0
 */
public class VolatileNotAtomic2 {

    private static volatile long count = 0L;
    private static final int NUMBER = 10000;

    //多次运行可以发现count并不是0，验证 volatile解决的是共享变量的可见性而不是原子性
    //解决方法是 count++  和count--加锁
    public static void main(String[] args) {
        Thread subtractThread = new SubtractThread();
        subtractThread.start();

        for (int i = 0; i < NUMBER; i++) {
            synchronized (VolatileNotAtomic2.class) {
                count++;
            }
        }

        while (subtractThread.isAlive()) {
        }
        System.out.println(count);
    }

    private static class SubtractThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < NUMBER; i++) {
                synchronized (VolatileNotAtomic2.class) {
                    count--;
                }
            }
        }
    }
}
