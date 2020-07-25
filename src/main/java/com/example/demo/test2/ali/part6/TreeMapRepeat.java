package com.example.demo.test2.ali.part6;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

/**
 * @ClassName TreeMapRepeat
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/25  9:38 下午
 * @Version 1.0
 */
public class TreeMapRepeat {
    public static void main(String[] args) {
         TreeMap map = new TreeMap();
        //HashMap map = new HashMap();
        map.put(new Key(), "one value");
        map.put(new Key(), "two value");

        System.out.println(map.size());
    }
}

class Key implements Comparable<Key> {

    @Override
    public int compareTo(Key o) {
        return -1;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
