package com.example.demo.test1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ChildService
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/20  9:19 下午
 * @Version 1.0
 */
@Service
@Slf4j
public class ChildService extends ParentService {

    void childPrint() {
        log.info("this is ChildService childPrint function");
    }

}
