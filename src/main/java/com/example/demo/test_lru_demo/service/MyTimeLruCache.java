package com.example.demo.test_lru_demo.service;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName MyTimeLruCache
 * @Description 实现一个线程安全并且带有过期时间的 LRU 缓存
 * @Author 孤 鸿
 * @Date 2020/6/20  6:52 下午
 * @Version 1.0
 */
public class MyTimeLruCache<K,V> {

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
    //定时器
    private ScheduledExecutorService scheduledExecutorService;

    /**
     * 构造函数初始化
     */
    public MyTimeLruCache(int cacheSize) {
        if (cacheSize < 0) {
            throw new IllegalArgumentException("Illegal Argument: " + cacheSize);
        }
        this.maxCapacity = cacheSize;
        cacheMap = new ConcurrentHashMap<>(maxCapacity);
        keysQue = new ConcurrentLinkedDeque<>();
        scheduledExecutorService =
                Executors.newScheduledThreadPool(3);
    }

    /**
    *  向缓存中插入元素
    * @author 孤 鸿
    * @CreateDate 7:04 下午 2020/6/20
    * @param k
     * @param v
     * @param expireTime
    * @return V
    */
    V put(K k, V v,long expireTime) {
        writeLock.lock();
        try {
            //是否包含此元素
            if (cacheMap.containsKey(k)) {
                moveToTail(k);
                cacheMap.put(k, v);
                return v;
            }
            //是否超出缓存，如果是就移除队头元素，及其对应的缓存
            if (keysQue.size() == maxCapacity) {
                System.out.println("macCapacity of cache reached");
                removeHeaderOne();
            }
            //k不在缓存中，添加到尾部，并且缓存k
            keysQue.add(k);
            cacheMap.put(k, v);

            if(expireTime > 0){
                removeAfterExpireTime(k,expireTime);
            }

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
            //取出元素的时候，元素放到队列尾部，因为头部是最先删除的元素，这样符合LRU原则
            if (null != k && cacheMap.containsKey(k)) {
                moveToTail(k);
                return cacheMap.get(k);
            }
        } finally {
            readLock.unlock();
        }
        return null;
    }

    /**
     * 删除一个元素
     */
    public V remove(K key) {
        writeLock.lock();
        try {
            //key是否存在当前缓存
            if (cacheMap.containsKey(key)) {
                keysQue.remove(key);
                return cacheMap.remove(key);
            }
            return null;
        } finally {
            writeLock.unlock();
        }
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

    public int size(){
        return cacheMap.size();
    }

    /**
    *  过期删除数据
    * @author 孤 鸿
    * @CreateDate 7:01 下午 2020/6/20
    * @param key
     * @param expireTime
    * @return void
    */
    public void removeAfterExpireTime(K key,long expireTime){
        scheduledExecutorService.schedule(()->{
            cacheMap.remove(key);
            keysQue.remove(key);
        },expireTime, TimeUnit.MILLISECONDS);
    }

}
