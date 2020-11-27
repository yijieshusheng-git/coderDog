package com.example.demo.test1.javabase;

/**
 * @ClassName StaticInnerTest
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/9/26  11:18 下午
 * @Version 1.0
 */
public class StaticInnerTest {

    private String name;
    private static String age;


    static class Inner{
        void print(){
            System.out.println(age);
          //  System.out.println(name);
        }
    }

}
