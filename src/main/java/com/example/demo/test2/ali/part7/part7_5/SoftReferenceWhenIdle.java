package com.example.demo.test2.ali.part7.part7_5;

import java.lang.ref.WeakReference;

/**
 * @ClassName SoftReferenceWhenIdle
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/8/2  10:01 下午
 * @Version 1.0
 */
public class SoftReferenceWhenIdle {

    public static void main(String[] args) {
        House seller = new House();
        //SoftReference<House> buyer2 = new SoftReference<>(seller);
        WeakReference<House> buyer2 = new WeakReference<>(seller);
        seller = null;

        while (true) {
            System.gc();
            System.runFinalization();

            if (buyer2.get() == null) {
                System.out.println("house is null.");
                break;
            } else {
                System.out.println("still here ....");
            }
        }

    }

}
