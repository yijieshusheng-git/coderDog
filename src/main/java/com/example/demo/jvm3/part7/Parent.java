package com.example.demo.jvm3.part7;

/**
 * @ClassName Parent
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/8/17  9:18 下午
 * @Version 1.0
 */
public class Parent {

    public static int A = 1;

    static {
        A = 2;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);
    }
}

class Sub extends Parent {
    public static int B = A;
}
