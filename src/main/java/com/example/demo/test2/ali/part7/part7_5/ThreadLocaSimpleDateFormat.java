package com.example.demo.test2.ali.part7.part7_5;

import java.text.SimpleDateFormat;
import java.text.*;

/**
 * @ClassName ThreadLocaSimpleDateFormat
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/8/2  11:01 下午
 * @Version 1.0
 */
public class ThreadLocaSimpleDateFormat {

    private static final ThreadLocal<DateFormat> DATA_FORMAT_THREAD_LOCAL
            = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public static void main(String[] args) {
        DateFormat dateFormat = DATA_FORMAT_THREAD_LOCAL.get();
        dateFormat.getNumberFormat();
    }

}
