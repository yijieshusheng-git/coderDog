package com.example.demo.test2.ali.part6;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ToArraySpeedTest
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/22  11:37 下午
 * @Version 1.0
 */
public class ToArraySpeedTest {

    private static final int COUNT = 100 * 100 * 100;

    public static void main(String[] args) {
        List<Double> list = new ArrayList<>(COUNT);

        for (int i = 0; i < COUNT; i++) {
            list.add(i * 1.0);
        }

        long start = System.nanoTime();

        Double[] notEnoughArray = new Double[COUNT - 1];
        list.toArray(notEnoughArray);

        long middle1 = System.nanoTime();

        Double[] equalArray = new Double[COUNT];
        list.toArray(equalArray);

        long middle2 = System.nanoTime();

        Double[] doubleArray = new Double[COUNT * 2];
        list.toArray(doubleArray);
        long end = System.nanoTime();

        long notEnoughArrayTime = middle1 - start;
        long equalArrayTime = middle2 - middle1;
        long doubleArrayTime = end - middle2;

        System.out.println("数组容量小于集合大小：notEnoughArrayTime：" +
                notEnoughArrayTime / (1000.0 * 1000.0) + "ms");
        System.out.println("数组容量等于集合大小: equalArrayTime: " +
                equalArrayTime / (1000.0 * 1000.0) + "ms");
        System.out.println("数组容量等于集合大小两倍: doubleArrayTime: " +
                doubleArrayTime / (1000.0 * 1000.0) + "ms");

    }

}
