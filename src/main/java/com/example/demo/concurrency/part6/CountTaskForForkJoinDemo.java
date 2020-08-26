package com.example.demo.concurrency.part6;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @ClassName CountTaskForForkJoinDemo
 * @Description Fork Join 测试
 * @Author 孤 鸿
 * @Date 2020/8/26  9:37 下午
 * @Version 1.0
 */
public class CountTaskForForkJoinDemo extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 2;

    private int start;
    private int end;

    public CountTaskForForkJoinDemo(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        boolean canCompute = (end - start) < THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            int middle = (start + end) / 2;
            CountTaskForForkJoinDemo leftTask = new CountTaskForForkJoinDemo(start, middle);
            CountTaskForForkJoinDemo rightTask = new CountTaskForForkJoinDemo(middle + 1, end);
            leftTask.fork();
            rightTask.fork();
            Integer leftResult = leftTask.join();
            Integer rightResult = rightTask.join();
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTaskForForkJoinDemo task = new CountTaskForForkJoinDemo(1, 4);
        ForkJoinTask<Integer> result = forkJoinPool.submit(task);
        try {
            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException e) {
        }
    }

}
