package com.example.demo.test2.ali.part7.part7_5;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName InitValueInThreadLocal
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/8/2  10:42 下午
 * @Version 1.0
 */
public class InitValueInThreadLocal {

    private static final StringBuilder INIT_VALUE = new StringBuilder("init");
    private static final ThreadLocal<StringBuilder> builder = ThreadLocal.withInitial(() -> INIT_VALUE);

    private static class AppendStringThread extends Thread {
        @Override
        public void run() {
            StringBuilder inThread = builder.get();
            for (int i = 0; i < 10; i++) {
                inThread.append("_").append(i);
            }
            System.out.println(inThread.toString());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new AppendStringThread().start();
        }
        TimeUnit.SECONDS.sleep(10);
    }

}
