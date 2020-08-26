package com.example.demo.niuke2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName JZ32
 * @Description 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @Author 孤 鸿
 * @Date 2020/8/18  11:13 下午
 * @Version 1.0
 */
public class JZ32 {

    public static String PrintMinNumber(int[] numbers) {
        if (numbers.length == 0) {
            return "";
        }

        int maxLen = 0;
        for (int number : numbers) {
            maxLen = Math.max(maxLen, String.valueOf(number).length());
        }

        List<String> list = new ArrayList<>();
        for (int number : numbers) {
            String str = String.valueOf(number);
            if (maxLen > str.length()) {
                //补全位数
                str += getSomeA(maxLen - str.length());
            }
            list.add(str);
        }

        list.sort(String::compareTo);
        String result = String.join("", list);
        return result.replace("A", "");
    }

    static String getSomeA(int num) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            builder.append("A");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{3, 32, 321};
        System.out.println(PrintMinNumber(numbers));
        int[] numbers2 = new int[]{3, 32, 345};
        System.out.println(PrintMinNumber(numbers2));

        List<String> list = Arrays.asList("300","320","345");
        list.sort(Comparator.naturalOrder());
        System.out.println(String.join("",list));
    }

}
