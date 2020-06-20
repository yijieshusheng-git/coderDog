package com.example.demo.test_lru_demo.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @ClassName MyTimeLruCacheTest
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/6/20  7:09 下午
 * @Version 1.0
 */
public class MyTimeLruCacheTest {

    @Test
    @DisplayName("定时清除策略的LRU缓存测试")
    public  void MyTimeLruCachetest() throws InterruptedException {
        MyTimeLruCache<Integer,String> myTimeLruCache = new MyTimeLruCache<>(3);
        myTimeLruCache.put(1,"java",3000);
        myTimeLruCache.put(2,"C++",3000);
        myTimeLruCache.put(3,"Pythen",1500);
        System.out.println(myTimeLruCache.size());
        Thread.sleep(2000);
        System.out.println(myTimeLruCache.size());
    }

}
