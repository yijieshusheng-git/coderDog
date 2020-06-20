package com.example.demo.test_lru_demo.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName myLruCacheTest
 * @Description 模拟最近最少使用原则的缓存测试
 * @Author 孤 鸿
 * @Date 2020/6/18  9:00 上午
 * @Version 1.0
 */
public class myLruCacheTest {

    @Test
    public void non_current_demoTest() {
        MyLruCache<Integer, String> myLruCache = new MyLruCache<>(3);
        myLruCache.put(1, "java");
        System.out.println(myLruCache.get(1));
        myLruCache.remove(1);
        System.out.println(myLruCache.get(1));
        myLruCache.put(2,"C++");
        myLruCache.put(3,"Python");
        System.out.println(myLruCache.get(2));
        myLruCache.put(4,"C");
        myLruCache.put(5,"PHP");
        System.out.println(myLruCache.get(2));
    }

    /**
    *  并发环境测试
    * @author 孤 鸿
    * @CreateDate 6:08 下午 2020/6/20
    * @param
    * @return void
    */
    @Test
    @DisplayName("并发环境测试")
    public void current_demoTest() throws InterruptedException {
        int threadNum = 10;
        int batchSize = 10000;
        //初始化缓存
        MyLruCache<String,Integer> myLruCache = new MyLruCache<>(batchSize * 10);
        //初始化线程池
        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
        //初始化倒计时器
        CountDownLatch latch = new CountDownLatch(threadNum);

        AtomicInteger integer = new AtomicInteger(0);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < threadNum; i++) {
            executorService.submit(()->{
                for (int j = 0; j < batchSize; j++) {
                    int value = integer.incrementAndGet();
                    myLruCache.put("id"+value,value);
                }
                latch.countDown();
            });
        }

        //等待 10个线程全部结束
        latch.await();
        executorService.shutdown();
        System.out.println("Cache Size: "+ myLruCache.size());
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println(String.format("Time cost: %dms",duration));

    }

}
