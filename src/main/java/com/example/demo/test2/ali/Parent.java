package com.example.demo.test2.ali;

/**
 * @ClassName Parent
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/11  2:13 下午
 * @Version 1.0
 */
public class Parent {

    static {
        System.out.println("Parent 静态代码快");
    }
    public Parent(){
        System.out.println("Parent  构造方法");
    }
}

class Son extends Parent{
    {
        System.out.println("Son 非静态代码块 after static");
    }
    static {
        System.out.println("Son 静态代码块");
    }

    {
        System.out.println("Son 非静态代码块 after static");
    }

    public Son(){
        System.out.println("Son 构造方法");
    }

    public static void main(String[] args) {
        new Son();
      Parent p =  new Son();

      Son son = (Son) new Parent();
    }
}
