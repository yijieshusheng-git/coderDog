package com.example.demo.test2.ali;

/**
 * @ClassName LongIntegerCacheTest
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/11  3:36 下午
 * @Version 1.0
 */
public class LongIntegerCacheTest {

    public static void main(String[] args) {
        Long a = 127L;
        Long b = 127L;
        System.out.println("Long max cached value is 127," + "and result is:"+ (a==b));

        Long a1 = 128L;
        Long b1 = 128L;
        System.out.println("Long =128 cache is" + (a1 == b1));

        Long c = -128L;
        Long d = -128L;
        System.out.println("Long min cached value is -128," + "and result is:"+ (c==d));

        Long c1 = -129L;
        Long d1 = -129L;
        System.out.println("Long =-129 cache is" + (c1 == d1));

        Long e = 1000L;
        Long f = 1000L;
        System.out.println("Long = 1000 cache is" + (e == f));

    }

}
