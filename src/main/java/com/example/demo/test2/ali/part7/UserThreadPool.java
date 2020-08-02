package com.example.demo.test2.ali.part7;

import java.util.concurrent.*;

/**
 * @ClassName UserThreadPool
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/8/2  3:15 下午
 * @Version 1.0
 */
public class UserThreadPool {

    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingDeque(2);

        UserThreadFactory userThreadFactory1 = new UserThreadFactory("第1机房");
        UserThreadFactory userThreadFactory2 = new UserThreadFactory("第2机房");

        UserRejectHandler userRejectHandler = new UserRejectHandler();

        ThreadPoolExecutor threadPoolExecutor1 =
                new ThreadPoolExecutor(1, 2, 60,
                        TimeUnit.SECONDS, queue,
                        userThreadFactory1,
                        userRejectHandler);
        ThreadPoolExecutor threadPoolExecutor2 =
                new ThreadPoolExecutor(1, 2, 60,
                        TimeUnit.SECONDS, queue,
                        userThreadFactory2,
                        userRejectHandler);

        Runnable task = new Task();
        for (int i = 0; i < 400; i++) {
            threadPoolExecutor1.execute(task);
            threadPoolExecutor2.execute(task);
        }

    }

}
