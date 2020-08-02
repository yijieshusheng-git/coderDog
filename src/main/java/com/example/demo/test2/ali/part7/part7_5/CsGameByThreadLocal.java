package com.example.demo.test2.ali.part7.part7_5;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @ClassName CsGameByThreadLocal
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/8/2  10:16 下午
 * @Version 1.0
 */
public class CsGameByThreadLocal {

    private static final Integer BULLET_NUMBER = 1500;
    private static final Integer KILLED_ENEMIES = 0;
    private static final Integer LIFE_VALUE = 10;
    private static final Integer TOTAL_PLAYERS = 10;
    //随机数
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    //初始化子弹数
    private static final ThreadLocal<Integer> BULLET_NUMBER_THREADLOCAL
            = ThreadLocal.withInitial(() -> BULLET_NUMBER);
    //初始化杀敌数
    private static final ThreadLocal<Integer> KILLED_ENEMIES_THREAD_LOCAL
            = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return KILLED_ENEMIES;
        }
    };
    //初始化自己的命数
    private static final ThreadLocal<Integer> LIFE_VALUE_THREAD_LOCAL
            = ThreadLocal.withInitial(() -> LIFE_VALUE);

    private static class Player extends Thread {
        @Override
        public void run() {
            int bullets = BULLET_NUMBER_THREADLOCAL.get() - RANDOM.nextInt(BULLET_NUMBER);
            int killEnemies = KILLED_ENEMIES_THREAD_LOCAL.get() - RANDOM.nextInt(TOTAL_PLAYERS / 2);
            int lifeValue = LIFE_VALUE_THREAD_LOCAL.get() - RANDOM.nextInt(LIFE_VALUE);

            System.out.println(getName() + ", BULLET_NUMBER is " + bullets);
            System.out.println(getName() + ", KILLED_ENEMIES is " + killEnemies);
            System.out.println(getName() + ", LIFE_ENEMIES is " + lifeValue);

            BULLET_NUMBER_THREADLOCAL.remove();
            KILLED_ENEMIES_THREAD_LOCAL.remove();
            LIFE_VALUE_THREAD_LOCAL.remove();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < TOTAL_PLAYERS; i++) {
            new Player().start();
        }
    }

}
