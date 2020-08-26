package com.example.demo.concurrency.part7;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @ClassName AtomicReferenceTest
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/8/26  10:26 下午
 * @Version 1.0
 */
public class AtomicReferenceTest {
    public static AtomicReference<User> atomicReference = new AtomicReference<>();

    public static void main(String[] args) {
        User user = new User("conan", 13);
        atomicReference.set(user);
        User updateUser = new User("shichi", 23);
        System.out.println(atomicReference.compareAndSet(user, updateUser));;
        System.out.println(atomicReference.get().getName());
        System.out.println(atomicReference.get().getOld());
    }

     static class User {
        private String name;
        private int old;

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
