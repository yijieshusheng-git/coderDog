package com.example.demo.test1.aop;

import java.lang.annotation.*;

/**
 * @ClassName MyLog
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/6/13  11:06 下午
 * @Version 1.0
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyLog {


}
