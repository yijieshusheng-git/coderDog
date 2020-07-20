package com.example.demo.test1.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @ClassName ParentService
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/20  9:32 下午
 * @Version 1.0
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ParentServiceTest1 {

    @Autowired
    private ParentService parentService;

    @Test
    public void test(){
        parentService.parentPrint();
    }
}
