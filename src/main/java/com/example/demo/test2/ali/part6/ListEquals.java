package com.example.demo.test2.ali.part6;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @ClassName ListEquals
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/24  10:38 下午
 * @Version 1.0
 */
public class ListEquals {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);

        System.out.println(arrayList.equals(linkedList));

    }

}
