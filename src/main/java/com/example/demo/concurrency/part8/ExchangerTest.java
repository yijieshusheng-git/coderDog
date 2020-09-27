package com.example.demo.concurrency.part8;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName ExchangerTest
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/8/27  8:33 上午
 * @Version 1.0
 */
public class ExchangerTest {

    private static final Exchanger<String> exchanger = new Exchanger<>();

    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String A = "银行流水A";
                try {
                    String exchange = exchanger.exchange(A);
                    System.out.println("A 后:"+exchange);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.execute(() -> {
            String B = "银行流水B";
            try {
                String A = exchanger.exchange(B);
                System.out.println("B 后:"+ A);
                System.out.println("A 和 B 是否一致: " + A.equals(B)
                        + ", A 录入的是:" + A + ", B 录入的是: " + B);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


    }

}
