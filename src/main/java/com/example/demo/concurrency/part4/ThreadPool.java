package com.example.demo.concurrency.part4;

/**
 * @ClassName ThreadPool
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/8/18  10:25 上午
 * @Version 1.0
 */
public interface ThreadPool<Job extends Runnable> {

    void execute(Job job);

    void shutdown();

    void addWorkers(int num);

    void removeWorker(int num);

    int gtJobSize();

}
