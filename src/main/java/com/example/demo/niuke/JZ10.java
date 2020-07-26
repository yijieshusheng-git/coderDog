package com.example.demo.niuke;

/**
 * @ClassName JZ10
 * @Description 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @Author 孤 鸿
 * @Date 2020/7/26  2:43 下午
 * @Version 1.0
 */
public class JZ10 {

    //斐波拉契数列
    //链接：https://www.nowcoder.com/questionTerminal/72a5a919508a4251859fb2cfb987a0e6?answerType=1&f=discussion
    //来源：牛客网
    //
    //涂掉最后一级矩形的时候，是用什么方式完成的？
    //
    //n = 1 的时候
    //只能横着覆盖，一种
    //n = 2 的时候
    //可以横着和竖着覆盖，两种
    //n = 3 的时候
    //第三级横着覆盖，用了一级，剩下 n = 2，有两种覆盖方法
    //第三季竖着覆盖，用了两级，剩下 n = 1，有一种覆盖方法
    //总共有 3 种
    //n = 4 的时候
    //第 4 级横着覆盖，用了一级，剩下 n = 3，有三种覆盖方法
    //第 4 级竖着覆盖，用了两级，剩下 n = 2，有两种覆盖方法
    //总共有 5 种方法
    //n = n 的时候
    //第 n 级横着覆盖，用了一级，剩下 n = n - 1，所以关注第 n - 1 种有几种覆盖方法
    //第 n 级竖着覆盖，用了两级，剩下 n = n - 2，所以关注第 n - 2 种有几种覆盖方法
    //总和为两种情况的总和
    public int RectCover(int target) {
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
