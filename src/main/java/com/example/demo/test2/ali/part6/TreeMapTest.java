package com.example.demo.test2.ali.part6;

import java.util.TreeMap;

/**
 * @ClassName TreeMapTest
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/25  10:27 下午
 * @Version 1.0
 */
public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(55,"fifty-five");
        treeMap.put(56,"fifty-six");
        treeMap.put(57,"fifty-seven");
        treeMap.put(58,"fifty-eigth");
        treeMap.put(83,"eighty-three");
        treeMap.remove(57);
        treeMap.put(59,"fifty-nine");
        System.out.println(treeMap);;
    }

}
