package com.example.demo.jvm3.part7;



/**
 * @ClassName ConstClass
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/8/11  10:55 下午
 * @Version 1.0
 */
public class ConstClass {

    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLOWORLD = "hello world";

}

class NotInitialization2{
    public static void main(String[] args) {
        System.out.println(ConstClass.HELLOWORLD);
    }
}
