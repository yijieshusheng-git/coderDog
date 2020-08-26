package com.example.demo.concurrency.part4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName DefaultThreadPool
 * @Description 一个简单地线程池案例
 * @Author 孤 鸿
 * @Date 2020/8/18  10:36 上午
 * @Version 1.0
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {

    private static final int MAX_WORKER_NUMBERS = 10;
    private static final int DEFAULT_WORKER_NUMBERS = 5;
    private static final int MIN_WORKER_NUMBERS = 1;
    /**
     * 工作列表
     */
    private final LinkedList<Job> jobs = new LinkedList<>();
    /**
     * 工作者列表
     */
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<>());
    /**
     * 工作者线程数量
     */
    private int workerNum = DEFAULT_WORKER_NUMBERS;
    /**
     * 线程编号生成
     */
    private AtomicLong threadNum = new AtomicLong();

    public DefaultThreadPool() {
        initializeWorker(DEFAULT_WORKER_NUMBERS);
    }

    public DefaultThreadPool(int num) {
        workerNum = num > MAX_WORKER_NUMBERS ? MAX_WORKER_NUMBERS : Math.max(num, MIN_WORKER_NUMBERS);
        initializeWorker(workerNum);
    }

    /**
     * 初始化
     */
    private void initializeWorker(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            new Thread(worker, "ThreadPool-Worker-" + threadNum.incrementAndGet()).start();
        }
    }

    @Override
    public void execute(Job job) {
        if (job != null) {
            //添加一个工作，然后通知
            synchronized (jobs) {
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        for (Worker worker : workers) {
            worker.shutdown();
        }
    }

    @Override
    public void addWorkers(int num) {
        synchronized (jobs) {
            if (num + this.workerNum > MAX_WORKER_NUMBERS) {
                num = MAX_WORKER_NUMBERS - this.workerNum;
            }
            initializeWorker(num);
            this.workerNum += num;
        }
    }

    @Override
    public void removeWorker(int num) {
        synchronized (jobs) {
            if (num > this.workerNum) {
                throw new IllegalArgumentException("beyond workNum");
            }
            int count = 0;
            while (count < num) {
                Worker worker = workers.get(count);
                if (workers.remove(worker)) {
                    worker.shutdown();
                    count++;
                }
            }
            this.workerNum -= count;
        }
    }

    @Override
    public int gtJobSize() {
        return jobs.size();
    }

    class Worker implements Runnable {
        private volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                Job job = null;
                synchronized (jobs) {
                    while (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            //???  感知到外部对 WorkerThread的中断操作，返回 :interrupt()其作用是中断此线程（此线程不一定是当前线程，而是指调用该方法的Thread实例所代表的线程），但实际上只是给线程设置一个中断标志，线程仍会继续运行。
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    job = jobs.removeFirst();
                }
                if (job != null) {
                    try {
                        job.run();
                    } catch (Exception e) {
                    }
                }
            }
        }

        public void shutdown() {
            running = false;
        }

    }
}
