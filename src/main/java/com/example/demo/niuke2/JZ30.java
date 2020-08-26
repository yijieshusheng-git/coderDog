package com.example.demo.niuke2;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JZ30
 * @Description HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,
 * 问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},
 * 连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 * @Author 孤 鸿
 * @Date 2020/8/11  11:22 下午
 * @Version 1.0
 */
public class JZ30 {

    //方法一：动态规划
    //状态定义：dp[i]表示以i结尾的连续子数组的最大和。所以最终要求dp[n-1]
    //状态转移方程：dp[i] = max(array[i], dp[i-1]+array[i])
    //解释：如果当前元素为整数，并且dp[i-1]为负数，那么当然结果就是只选当前元素
    //技巧：这里为了统一代码的书写，定义dp[i]表示前i个元素的连续子数组的最大和，结尾元素为array[i-1]
    public static int FindGreatestSumOfSubArray(int[] array) {
        List<Integer> dp = new ArrayList<>();
        if (array.length == 0) {
            return 0;
        }

        dp.add(array[0]);
        for (int i = 1; i < array.length; i++) {
            dp.add(Math.max(array[i], dp.get(i - 1) + array[i]));
        }

        int max = dp.get(0);
        for (Integer temp : dp) {
            max = Math.max(max, temp);
        }

        return max;
    }

    //方法二：空间复杂度O(1)解法 :在动态规划的基础上，节省空间的做法
    //    思想很简单，就是对下标为i的元素array[i]，先试探的加上array[i], 如果和为负数，显然，
    //    以i结尾的元素对整个结果不作贡献。
    //    具体过程：
    //
    //    初始化：维护一个变量tmp = 0
    //    如果tmp+array[i] < 0, 说明以i结尾的不作贡献，重新赋值tmp = 0
    //    否则更新tmp = tmp + array[i]
    //    最后判断tmp是否等于0， 如果等于0， 说明数组都是负数，选取一个最大值为答案。
    public static int FindGreatestSumOfSubArray2(int[] array) {
        //最后结果值
        int result = array[0];
        //贡献值
        int temp = 0;
        for (int i = 0; i < array.length; ++i) {
            if (temp + array[i] < 0) {
                temp = 0;
            } else {
                temp += array[i];
            }
            result = Math.max(temp, result);
        }

        if (temp != 0) {
            return result;
        }

        result = array[0];
        for (int i = 1; i < array.length; i++) {
            result = Math.max(result, array[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(FindGreatestSumOfSubArray(array));
        System.out.println(FindGreatestSumOfSubArray2(array));
    }

}
