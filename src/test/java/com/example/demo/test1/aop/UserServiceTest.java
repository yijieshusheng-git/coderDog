package com.example.demo.test1.aop;

import com.example.demo.MyFirstSpringBootAppApplication;
import com.example.demo.test1.dao.UserNameHandler;
import com.example.demo.test1.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName UserServiceTest
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/6/14  2:10 下午
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyFirstSpringBootAppApplication.class)
public class UserServiceTest {

    @Autowired
    private UserService service;

    @Test
    public void test1(){
       service.function1();
        //根据切面里面的设置，这里直接转化
        UserNameHandler handler = (UserNameHandler) service;
        handler.setUserName();
    }

}
