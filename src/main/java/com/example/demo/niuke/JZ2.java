package com.example.demo.niuke;

/**
 * @ClassName JZ2
 * @Description 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @Author 孤 鸿
 * @Date 2020/7/27  10:16 下午
 * @Version 1.0
 */
public class JZ2 {

    public String replaceSpace(StringBuffer str) {
        if (null == str) {
            return "";
        }
        return str.toString().replace(" ", "%20");
    }

}
