package com.example.demo.concurrency.part7;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @ClassName AtomicIntegerFieldUpdateTest
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/8/26  10:34 下午
 * @Version 1.0
 */
public class AtomicIntegerFieldUpdateTest {

    private static AtomicIntegerFieldUpdater<User> a =
            AtomicIntegerFieldUpdater.newUpdater(User.class,"old");

    public static void main(String[] args) {
        User conan = new User("conan",10);
        System.out.println(a.getAndIncrement(conan));
        System.out.println(a.get(conan));
    }

     static class User {
        private String name;
        public volatile int old;

        public String getName() {
            return name;
        }

        public int getOld() {
            return old;
        }

        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }

    }
}
