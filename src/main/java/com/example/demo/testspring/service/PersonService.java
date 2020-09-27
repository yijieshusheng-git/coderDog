package com.example.demo.testspring.service;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/9/5  10:48 下午
 * @Version 1.0
 */
@Component
public class PersonService  implements BeanNameAware {

    private String beanName;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        System.out.println("PersonService: "+ beanName);
    }

    public void print(){
        System.out.println("this is PersonService print function");
    }
}
