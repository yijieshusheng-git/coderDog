package com.example.demo.test2.ali;

/**
 * @ClassName StaticCode
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/11  2:21 下午
 * @Version 1.0
 */
public class StaticCode {

    static String prior = "done";
    static String last = f() ? g() : prior;

    public static  boolean f(){
        return true;
    }

    public static String g(){
        return "hello world";
    }

    static {
        System.out.println(last);
        g();
    }

}
