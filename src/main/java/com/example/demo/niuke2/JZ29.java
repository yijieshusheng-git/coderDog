package com.example.demo.niuke2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName JZ29
 * @Description 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * @Author 孤 鸿
 * @Date 2020/8/11  10:28 下午
 * @Version 1.0
 */
public class JZ29 {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input.length == 0 || k <= 0 || k > input.length) {
            return result;
        }

        int[] array = Arrays.stream(input).sorted().limit(k).toArray();
        for (int value : array) {
            result.add(value);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{4,5,1,6,2,7,3,8};
        ArrayList<Integer> integers = GetLeastNumbers_Solution(input, 4);
        integers.forEach(System.out::println);
    }

}
