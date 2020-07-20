package com.example.demo.test1.service;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

/**
 * @ClassName ParentServiceTest2
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/20  9:34 下午
 * @Version 1.0
 */
@Ignore
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
public class ParentServiceTest2 {

    @Autowired
    private ParentService ssss;

    @Test
    public void test(){
        ssss.parentPrint();
    }
}
