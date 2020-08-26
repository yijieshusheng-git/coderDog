package com.example.demo.niuke;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName JZ27
 * @Description 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * @Author 孤 鸿
 * @Date 2020/8/6  6:41 下午
 * @Version 1.0
 */
public class JZ27 {

    public static void main(String[] args) {
        ArrayList<String> result = Permutation("abc");
        result.forEach(System.out::println);
    }

    //递归
    public static ArrayList<String> Permutation(String str) {
        if (null == str || "".equals(str)) {
            return new ArrayList<>();
        }

        List<String> oneList = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            oneList.add(String.valueOf(aChar));
        }

        ArrayList<String> result = new ArrayList<>();
        result.add(oneList.get(0));
        for (int i = 1; i < chars.length; i++) {
            ArrayList<String> tempList = new ArrayList<>();

            for (String s : result) {
                tempList.addAll(insertOneChar(oneList.get(i), s));
            }
            result.clear();
            result.addAll(tempList);
        }

        Set<String> set = new HashSet<>(result);
        result.clear();
        result.addAll(set);
        result.sort(String::compareTo);

        return result;
    }


    //把一个字符插入到一个字符串中
    static ArrayList<String> insertOneChar(String one, String string) {
        ArrayList<String> result = new ArrayList<>();

        if (null == one || "".equals(one)) {
            result.add(string);
            return result;
        }

        if (null == string || "".equals(string)) {
            result.add(one);
            return result;
        }

        StringBuilder builder = new StringBuilder();
        builder.append(one).append(string);
        result.add(builder.toString());

        int length = string.length();
        for (int i = 1; i < length; i++) {
            builder = new StringBuilder();
            String substring1 = string.substring(0, i);
            String substring2 = string.substring(i, length);
            builder.append(substring1).append(one).append(substring2);
            result.add(builder.toString());
        }
        builder = new StringBuilder();
        builder.append(string).append(one);
        result.add(builder.toString());

        Set<String> set = new HashSet<>(result);
        result.clear();
        result.addAll(set);

        return result;
    }

}
