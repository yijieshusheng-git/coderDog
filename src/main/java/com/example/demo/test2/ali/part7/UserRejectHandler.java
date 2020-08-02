package com.example.demo.test2.ali.part7;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName UserRejectHandler
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/8/2  3:18 下午
 * @Version 1.0
 */
public class UserRejectHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("task rejected. " + executor.toString());
    }

}
