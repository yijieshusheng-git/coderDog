package com.example.demo.concurrency.part4;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName SleepUtils
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/8/19  3:23 下午
 * @Version 1.0
 */
public class SleepUtils {

    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
