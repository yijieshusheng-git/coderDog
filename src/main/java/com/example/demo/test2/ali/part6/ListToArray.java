package com.example.demo.test2.ali.part6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ListToArray
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/22  11:05 下午
 * @Version 1.0
 */
public class ListToArray {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(3);
        list.add("one");
        list.add("two");
        list.add("three");

        Object[] array1 = list.toArray();

        String[] array2 = new String[2];
        list.toArray(array2);
        System.out.println(Arrays.asList(array2));

        String[] array3 = new String[3];
        list.toArray(array3);
        System.out.println(Arrays.asList(array3));

    }

}
