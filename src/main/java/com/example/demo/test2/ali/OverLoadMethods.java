package com.example.demo.test2.ali;

/**
 * @ClassName OverLoadMethods
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/11  2:49 下午
 * @Version 1.0
 */
public class OverLoadMethods {

    public void methodForOverload(){
        System.out.println("无参方法");
    }

    public void methodForOverload(int param) {
        System.out.println("参数类型是int 的方法");
    }

    public void methodForOverload(Integer param) {
        System.out.println("参数类型是 Integer 的方法");
    }

    public void methodForOverload(Integer... param) {
        System.out.println("参数类型是 Integer可变参数 的方法");
    }

    public void methodForOverload(Object param) {
        System.out.println("参数类型是 Object 的方法");
    }

    public void methodForOverload(int param,Integer param2) {
        System.out.println("参数类型是 int,Integer 的方法");
    }

    public void methodForOverload(Integer param,int param2) {
        System.out.println("参数类型是 Integer,int 的方法");
    }


    public static void main(String[] args) {
        OverLoadMethods overLoadMethods = new OverLoadMethods();
        overLoadMethods.methodForOverload();
        overLoadMethods.methodForOverload(7);

        //overLoadMethods.methodForOverload(13,14);
    }
    }
