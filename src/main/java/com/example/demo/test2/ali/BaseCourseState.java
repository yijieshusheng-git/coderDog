package com.example.demo.test2.ali;

/**
 * @ClassName BaseCourseState
 * @Description 用不能实例化的抽象类来存放 全局常量信息
 * @Author 孤 鸿
 * @Date 2020/7/11  9:34 下午
 * @Version 1.0
 */
public abstract class BaseCourseState {

    public static final int NEW_COURSE = 1;

    public static final int UNCAUGHT_COURSE = 2;

    public static final int PASSED_COURSE = 3;

    public static final int NOT_PASSED_COURSE = 4;

    public static final int DELETE_COURSE = 5;


}
