package com.example.demo.niuke;

/**
 * @ClassName JZ11
 * @Description 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 * @Author 孤 鸿
 * @Date 2020/7/26  3:08 下午
 * @Version 1.0
 */
public class JZ11 {

    public static int NumberOf1(int n) {
        int result = 0;
        if (n == 0) {
            return result;
        }

        int x = 0x01;
        while (x != 0) {
            if ((x & n) == 1) {
                result++;
            }
            x <<= 1;
        }
        return result;
    }

    public static int NumberOf2(int n) {
        int result = 0;
        if (n == 0) {
            return result;
        }

        while (n != 0) {
            if ((n & 0x01) == 1) {
                result++;
            }
            n >>>=1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(10));
        System.out.println(NumberOf2(10));
    }


}
