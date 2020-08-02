package com.example.demo.test2.ali.part7;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName UserThreadFactory
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/8/2  2:54 下午
 * @Version 1.0
 */
public class UserThreadFactory implements ThreadFactory {

    private final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger(1);

    public UserThreadFactory(String whatFeatureOfGroup) {
        this.namePrefix = "UserThreadFactory`s" +whatFeatureOfGroup +"-Worker-";
    }


    @Override
    public Thread newThread(Runnable task) {
        String name = namePrefix+nextId.getAndIncrement();
        Thread thread = new Thread(null,task,name);
        System.out.println(thread.getName());
        return thread;
    }

    public static void main(String[] args) {
        UserThreadFactory userThreadFactory = new UserThreadFactory("lxw");
        userThreadFactory.newThread(new Task()).start();
    }
}

class Task implements Runnable{
    private final AtomicLong count = new AtomicLong(0L);

    @Override
    public void run() {
        System.out.println("running_ " + count.getAndIncrement());
    }
}
