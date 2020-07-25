package com.example.demo.test2.ali.part6;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SubListFailFast
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/24  10:59 下午
 * @Version 1.0
 */
public class SubListFailFast {

    public static void main(String[] args) {
        List materList = new ArrayList();
        materList.add("one");
        materList.add("two");
        materList.add("three");
        materList.add("four");
        materList.add("five");

        List branchList = materList.subList(0, 3);

        materList.remove(0);
        materList.add("ten");
        materList.clear();

        branchList.clear();
        branchList.add("six");
        branchList.add("seven");
        branchList.remove(0);

        for (Object t : branchList) {
            System.out.println(t);
        }

        System.out.println(materList);

    }

}
