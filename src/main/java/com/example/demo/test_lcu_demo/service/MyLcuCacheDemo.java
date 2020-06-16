package com.example.demo.test_lcu_demo.service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName MyLcuCacheDemo
 * @Description LCU 策略下的 缓存模拟
 * @Author 孤 鸿
 * @Date 2020/6/15  9:25 下午
 * @Version 1.0
 */
public class MyLcuCacheDemo<K, V> {

    private final int maxCapacity;
    /**
     * 缓存数据的具体保存点-可以log(1)读取
     */
    private ConcurrentHashMap<K, V> cacheMap;
    /**
     * 缓存K队列
     */
    private ConcurrentLinkedDeque<K> keysQue;

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock writeLock = readWriteLock.writeLock();
    private Lock readLock = readWriteLock.readLock();

    /**
     * 构造函数初始化
     */
    public MyLcuCacheDemo(int cacheSize) {
        if (cacheSize < 0) {
            throw new IllegalArgumentException("Illegal Argument: " + cacheSize);
        }
        this.maxCapacity = cacheSize;
        cacheMap = new ConcurrentHashMap<>(maxCapacity);
        keysQue = new ConcurrentLinkedDeque<>();
    }

    /**
     * 向缓存中插入元素
     */
    V put(K k, V v) {
        writeLock.lock();
        try {
        /*  if(null == k || null == v){
              return null;
          }*/

            if (cacheMap.containsKey(k)) {
                moveToTail(k);
                cacheMap.put(k, v);
                return v;
            }
            //如果当前缓存没有包含此元素
            if (keysQue.size() == maxCapacity) {
                System.out.println("macCapacity of cache reached");
                removeHeaderOne();
            }
            //keysQue.offer(k);
            keysQue.add(k);
            cacheMap.put(k, v);
            return v;
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * 从缓存中获取元素
     */
    public V get(K k) {
        readLock.lock();
        try {
            if (null != k && cacheMap.contains(k)) {
                moveToTail(k);
                return cacheMap.get(k);
            }
        } finally {
            readLock.unlock();
        }
        return null;
    }

    /**
     * 将队列元素移动到队尾，表示 刚刚入列
     */
    void moveToTail(K k) {
        keysQue.remove(k);
        keysQue.offer(k);
    }

    /**
     * 队列满，删除队头元素
     */
    void removeHeaderOne() {
        K poll = keysQue.poll();
        //keysQue.remove(k);
        //cacheMap.remove(k);
        if (poll != null) {
            cacheMap.remove(poll);
        }
    }

}
