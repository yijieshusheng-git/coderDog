package com.example.demo.test1.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @ClassName ChildServiceTest
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/20  9:21 下午
 * @Version 1.0
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ChildServiceTest1 {

    @Autowired
    private ChildService childService;

    @Test
    public void test(){
        childService.childPrint();
    }

}
