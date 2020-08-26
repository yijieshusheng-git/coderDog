package com.example.demo.jvm3.part4;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OOMObject
 * @Description JConsole 使用
 * @Author 孤 鸿
 * @Date 2020/8/18  10:02 下午
 * @Version 1.0
 */
public class OOMObject {
    public byte[] placeholder = new byte[64 * 1024];

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws Exception {
        fillHeap(1000);
    }
}

