package com.example.demo.test1.javabase;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GenerticTest
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/9/27  9:42 下午
 * @Version 1.0
 */
public class GenerticTest {

    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        System.out.println(strList.getClass() == intList.getClass());

    }

}
