package com.example.demo.niuke;

/**
 * @ClassName JZ7
 * @Description 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n<=39
 * @Author 孤 鸿
 * @Date 2020/7/25  10:54 下午
 * @Version 1.0
 */
public class JZ7 {

    public static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public static int Fibonacci2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int[] fun = new int[n + 1];
        fun[0] = 0;
        fun[1] = 1;
        for (int i = 2; i <= n; ++i) {
            fun[i] = fun[i - 1] + fun[i - 2];
        }
        return fun[n];
    }

    public static int Fibonacci3(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int sumSub2 = 0;
        int sumSub1 = 1;
        int sum = sumSub1 + sumSub2;
        for (int i = 2; i <= n; i++) {
            sum = sumSub1 + sumSub2;
            sumSub2 = sumSub1;
            sumSub1 = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(3));
        System.out.println(Fibonacci2(4));
        System.out.println(Fibonacci3(4));
    }

}
