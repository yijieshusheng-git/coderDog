package com.example.demo.test1.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @ClassName ChildServiceTest2
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/20  9:28 下午
 * @Version 1.0
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ChildServiceTest2 {

    @Autowired
    private ChildService sssss;

    @Test
    public void test(){
        sssss.childPrint();
    }
}
