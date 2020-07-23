package com.example.demo.test2.ali.part6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ArraysAsList
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/22  10:46 下午
 * @Version 1.0
 */
public class ArraysAsList {

    public static void main(String[] args) {
        String[] stringArray = new String[3];
        stringArray[0] = "one";
        stringArray[1] = "two";
        stringArray[2] = "three";

        List<String> stringList = Arrays.asList(stringArray);
        //List<String> stringList = new ArrayList<>(Arrays.asList(stringArray)) ;
        String set = stringList.set(0, "oneList");
        System.out.println(set);
        System.out.println(stringArray[0]);

        stringList.add("four");
    }
}
