package com.example.demo.test2.ali.part7.part7_5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName DirtyDataInThreadLocal
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/8/2  11:09 下午
 * @Version 1.0
 */
public class DirtyDataInThreadLocal {

    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 2; i++) {
            MyThread thread = new MyThread();
            pool.execute(thread);
        }
    }

    private static class MyThread extends Thread {
        private static boolean flag = true;

        @Override
        public void run() {
            if (flag) {
                threadLocal.set(this.getName() + ".session info.");
                flag = false;
            }
            System.out.println(this.getName() + "线程是 " + threadLocal.get());
        }
    }

}
