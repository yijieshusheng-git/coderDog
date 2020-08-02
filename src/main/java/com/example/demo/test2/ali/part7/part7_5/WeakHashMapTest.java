package com.example.demo.test2.ali.part7.part7_5;

import com.example.demo.test2.ali.part7.part7_5.House;

import java.util.WeakHashMap;

/**
 * @ClassName WeakHashMapTest
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/8/2  10:07 下午
 * @Version 1.0
 */
public class WeakHashMapTest {

    public static void main(String[] args) {
        House seller1 = new House();
        SellerInfo sellerInfo1 = new SellerInfo();

        House seller2 = new House();
        SellerInfo sellerInfo2 = new SellerInfo();

        WeakHashMap<House,SellerInfo> weakHashMap
                = new WeakHashMap<>();
        weakHashMap.put(seller1,sellerInfo1);
        weakHashMap.put(seller2,sellerInfo2);

        System.out.println("weakHashMap before null, size = "+ weakHashMap.size());

        seller1 = null;

        System.gc();
        System.runFinalization();

        System.out.println("weakHashMap after null, size = "+ weakHashMap.size());

    }

    static class SellerInfo{}
}
