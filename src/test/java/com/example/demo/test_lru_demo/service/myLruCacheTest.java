package com.example.demo.test_lru_demo.service;

import org.junit.jupiter.api.Test;

/**
 * @ClassName myLruCacheTest
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/6/18  9:00 上午
 * @Version 1.0
 */
public class myLruCacheTest {

    @Test
    public void demoTest() {
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

}
