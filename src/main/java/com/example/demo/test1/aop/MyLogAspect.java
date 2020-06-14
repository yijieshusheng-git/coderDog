package com.example.demo.test1.aop;

import com.example.demo.test1.dao.UserNameHandler;
import com.example.demo.test1.dao.UserNameHandlerImpl;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyLogAspect
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/6/14  4:37 下午
 * @Version 1.0
 */
@Aspect
@Component
@Slf4j
@Order(-2)
public class MyLogAspect {

    @DeclareParents(value = "com.example.demo.test1.service.UserService",defaultImpl = UserNameHandlerImpl.class)
    UserNameHandler userNameHandler;

    @Around("@annotation(MyLog)")
    public Object aroundTest(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("{}","this MyLogAspect before");
        Object proceed = joinPoint.proceed();
        log.info("{}","this MyLogAspect after");
        return proceed;
    }

}
