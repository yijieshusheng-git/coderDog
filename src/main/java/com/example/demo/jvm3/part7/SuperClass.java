package com.example.demo.jvm3.part7;

/**
 * @ClassName SuperClass
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/8/11  10:44 下午
 * @Version 1.0
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;

}

class SubClass extends SuperClass{

    static {
        System.out.println("SubClass init!");
    }

}

class NotInititalization{

    public static void main(String[] args) {
        //System.out.println(SubClass.value);

        SuperClass[] superClasses = new SuperClass[10];

    }

}