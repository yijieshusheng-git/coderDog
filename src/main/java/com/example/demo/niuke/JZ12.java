package com.example.demo.niuke;

import java.math.BigDecimal;

/**
 * @ClassName JZ12
 * @Description 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 * @Author 孤 鸿
 * @Date 2020/7/26  9:55 下午
 * @Version 1.0
 */
public class JZ12 {

    public static double Power(double base, int exponent) {
        if (base == 0 * 1.0) {
            return 0.0;
        }
        if (exponent == 0) {
            return 1.0;
        }

        BigDecimal bigDecimal = new BigDecimal(base);
        BigDecimal result = new BigDecimal(0);

        if (exponent > 0) {
            result = bigDecimal.pow(exponent);
        } else {
            BigDecimal big1 = new BigDecimal(1).divide(bigDecimal);
            result = big1.pow(Math.abs(exponent));
        }

        return result.doubleValue();
    }

    //递归法
    public static double Power2(double base, int exponent) {
        if (exponent < 0) {
            base = 1.0 / base;
            exponent = -1 * exponent;
        }
        return powerDetail(base, exponent);
    }

    static double powerDetail(double base, int exponent) {
        if (base == 0) {
            return 0.0;
        }
        if (exponent == 0) {
            return 1.0;
        }

        double detail = powerDetail(base, exponent / 2);
        if ((exponent & 1) == 1) {
            return detail * detail * base;
        } else {
            return detail * detail;
        }
    }


    public static void main(String[] args) {
        System.out.println(Power(2, -3));
    }

}
