package com.example.demo.test1.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName JdkProxyExample
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/9/6  10:41 下午
 * @Version 1.0
 */
public class JdkProxyExample implements InvocationHandler {

    private Object target = null;

    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理逻辑方法");
        System.out.println("在调用真实对象之前的服务");

        Object obj = method.invoke(target, args);

        System.out.println("在调用真实对象之后的服务");

        return obj;
    }

}
