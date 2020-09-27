package com.example.demo.test1.jdkproxy;

/**
 * @ClassName TestJdkProxy
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/9/6  10:47 下午
 * @Version 1.0
 */
public class TestJdkProxy {

    public static void main(String[] args) {
        JdkProxyExample jdkProxyExample = new JdkProxyExample();
        HelloWorld proxy = (HelloWorld) jdkProxyExample.bind(new HelloWorldImpl());
        proxy.sayHelloWorld();
    }

}


