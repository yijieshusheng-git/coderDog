package com.example.demo.jvm3.part2;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName HeapOOM
 * @Description VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * java 堆内存溢出测试
 * @Author 孤 鸿
 * @Date 2020/8/4  10:49 下午
 * @Version 1.0
 */
public class HeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }

}
