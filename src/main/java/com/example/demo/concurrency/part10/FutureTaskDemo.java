package com.example.demo.concurrency.part10;

import java.util.concurrent.*;

/**
 * @ClassName FutureTaskDemo
 * @Description 多个线程同时执行一个任务的时候，只允许一个线程执行任务
 * @Author 孤 鸿
 * @Date 2020/8/29  1:51 下午
 * @Version 1.0
 */
public class FutureTaskDemo {

    private final ConcurrentHashMap<Object, Future<String>> taskCache = new ConcurrentHashMap<>();

    private String executionTask(final String taskName) throws ExecutionException, InterruptedException {
        while (true) {
            Future<String> future = taskCache.get(taskName);
            if (future == null) {
                Callable<String> task = () -> taskName;
                FutureTask<String> futureTask = new FutureTask<>(task);
                future = taskCache.putIfAbsent(taskName, futureTask);
                if (future == null) {
                    future = futureTask;
                    futureTask.run();
                }
            }

            try {
                return future.get();
            } catch (CancellationException e) {
                taskCache.remove(taskName, future);
            }

        }
    }


}
