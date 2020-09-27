package com.example.demo.testspring.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @ClassName PersonServiceTest
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/9/5  10:53 下午
 * @Version 1.0
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    public void te(){
        personService.print();
    }

}
