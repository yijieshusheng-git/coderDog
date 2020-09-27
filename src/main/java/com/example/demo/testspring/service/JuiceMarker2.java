package com.example.demo.testspring.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName JuiceMarker2
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/9/5  11:05 下午
 * @Version 1.0
 */
public class JuiceMarker2 implements BeanNameAware, BeanFactoryAware,
        ApplicationContextAware, InitializingBean, DisposableBean {

    private String beverageShop = null;
    private int  number = 0;

    public void setBeverageShop(String beverageShop) {
        this.beverageShop = beverageShop;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void init() {
        System.out.println("【" + this.getClass().getSimpleName() + "】执行自定义初始化方法");
    }

    public void myDestroy() {
        System.out.println("【" + this.getClass().getSimpleName() + "】执行自定义从销毁方法");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用BeanFactoryAware接口的setBeanFactory方法");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用BeanNameAware接口的setBeanName方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用DisposableBean接口的destroy方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用InitializingBean接口的afterPropertiesSet方法");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用ApplicationContextAware接口的setApplicationContext方法");
    }
}
