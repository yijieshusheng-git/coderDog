package com.example.demo.test2.ali.part7;

import java.util.concurrent.Semaphore;

/**
 * @ClassName CustomCheckWindow
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/29  9:55 下午
 * @Version 1.0
 */
public class CustomCheckWindow {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 5; i++) {
            new SecurityCheckThread(i,semaphore).start();
        }

    }

    private static class SecurityCheckThread extends Thread {
        private int seq;
        private Semaphore semaphore;

        public SecurityCheckThread(int seq, Semaphore semaphore) {
            this.semaphore = semaphore;
            this.seq = seq;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("No." + seq + "乘客，正在检查中");
                if (seq % 2 == 0) {
                    Thread.sleep(1000);
                    System.out.println("No." + seq + "乘客，身份可疑，不能出国！");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println("No." + seq + "乘客，已完成服务");
            }
        }

    }

}
