package com.example.demo.testspring.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @ClassName BeanPostProcessorImpl
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/9/5  11:02 下午
 * @Version 1.0
 */
public class BeanPostProcessorImpl implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("【" + bean.getClass().getSimpleName() + "】对象" + beanName + "开始实例化");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("【" + bean.getClass().getSimpleName() + "】对象" + beanName + "实例化完成");
        return bean;
    }
}
