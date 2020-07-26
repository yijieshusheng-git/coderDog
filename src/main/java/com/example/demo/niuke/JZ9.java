package com.example.demo.niuke;

/**
 * @ClassName JZ9
 * @Description 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @Author 孤 鸿
 * @Date 2020/7/26  2:12 下午
 * @Version 1.0
 */
public class JZ9 {

    public int JumpFloorII(int target) {
        if (target < 0 || target == 0 || target == 1 || target == 2) {
            return target;
        }

        int[] array = new int[target + 1];
        array[0] = 0;
        array[1] = 1;
        array[2] = 2;
        for (int i = 3; i <= target; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                temp += (i - j) * array[j];
            }
            array[i] = temp;
        }

      return (int) Math.pow(2,target);
        //return array[target];
    }

}
