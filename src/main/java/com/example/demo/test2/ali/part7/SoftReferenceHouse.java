package com.example.demo.test2.ali.part7;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SoftReferenceHouse
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/8/2  9:41 下午
 * @Version 1.0
 */
public class SoftReferenceHouse {

    public static void main(String[] args) {
        List<SoftReference> houses = new ArrayList<>();

    }

}

class House{
    private static final Integer DOOR_NUMBER = 2000;
    public Door[] doors = new Door[DOOR_NUMBER];

    class Door{}
}
