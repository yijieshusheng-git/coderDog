package com.example.demo.test1.service;

import com.example.demo.test1.aop.MyLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/6/13  11:04 下午
 * @Version 1.0
 */
@Service
@Slf4j
public class UserService {

   // @MyLog
    public String function1(){
        String str = "this is a UserService.function1";
        log.info("{}",str);
        return str;
    }

    public void function2(){
        System.out.println("test commit");
    }

    public void function3(){
        System.out.println("test commit");
    }

}


