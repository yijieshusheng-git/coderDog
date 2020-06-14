/*
package com.example.demo.test1.aop;

import com.example.demo.test1.dao.UserNameHandler;
import com.example.demo.test1.dao.UserNameHandlerImpl;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

*/
/**
 * @ClassName DeclareParentsAspect
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/6/13  11:08 下午
 * @Version 1.0
 *//*

@Aspect
@Component
@Slf4j
@Order(1)
public class DeclareParentsAspect {

    //让表达式中的类 动态实现一个接口 UserNameHandler
    @DeclareParents(value = "com.example.demo.test1.service.UserService",defaultImpl = UserNameHandlerImpl.class)
     UserNameHandler userNameHandler;

}
*/
