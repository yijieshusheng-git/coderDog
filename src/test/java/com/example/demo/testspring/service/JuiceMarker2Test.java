package com.example.demo.testspring.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName JuiceMarker2Test
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/9/5  11:15 下午
 * @Version 1.0
 */
public class JuiceMarker2Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("config/spring-config.xml");

        JuiceMarker2 juiceMarker2 = (JuiceMarker2) context.getBean("juiceMarker2");
        context.close();

    }

}
