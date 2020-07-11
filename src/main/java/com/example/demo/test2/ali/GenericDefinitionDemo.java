package com.example.demo.test2.ali;

/**
 * @ClassName GenericDefinitionDemo
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/11  3:06 下午
 * @Version 1.0
 */
public class GenericDefinitionDemo<T> {

    static <String,T,Integer> String get(String string,Integer int1){
        return string;
    }

    public static void main(String[] args) {
        Integer first =22;
        Long second = 333L;
        Integer result = get(first,second);

    }

}
