package com.example.demo.concurrency.part4;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName Join
 * @Description join 测试
 * @Author 孤 鸿
 * @Date 2020/8/19  4:44 下午
 * @Version 1.0
 */
public class Join {

    public static void main(String[] args) throws Exception {
        Thread previous = Thread.currentThread();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }

        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " terminate.");
    }

    static class Domino implements Runnable {
        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }
}
