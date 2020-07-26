package com.example.demo.niuke;

/**
 * @ClassName JZ8
 * @Description 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * @Author 孤 鸿
 * @Date 2020/7/26  1:44 下午
 * @Version 1.0
 */
public class JZ8 {

    public int JumpFloor(int target) {
        if (target == 0 || target == 1 || target == 2) {
            return target;
        }

        int n2 = 1;
        int n1 = 2;
        int result = n1 + n2;
        for (int i = 3; i <= target; i++) {
            result = n1 + n2;
            n2 = n1;
            n1 = result;
        }

        return result;
    }

}
