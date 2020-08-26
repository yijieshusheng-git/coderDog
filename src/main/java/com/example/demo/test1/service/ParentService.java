package com.example.demo.test1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName ParentService
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/20  9:18 下午
 * @Version 1.0
 */
@Service
@Slf4j
public class ParentService {

    void parentPrint() {
        log.info("this is ParentService parentPrint function");
    }

    public static void testStatic(){
        System.out.println("test static function whether can extend ?");
    }

}
