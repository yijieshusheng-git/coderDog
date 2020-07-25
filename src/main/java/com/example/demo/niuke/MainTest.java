package com.example.demo.niuke;

/**
 * @ClassName MainTest
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/25  4:26 下午
 * @Version 1.0
 */
public class MainTest {

    public static void main(String[] args) {
        //["PSH1","PSH2","PSH3","POP","POP","PSH4","POP","PSH5","POP","POP"]
        //对应输出应该为:
        //1,2,3,4,5
        //你的输出为:
        //1,2,4,5,3
        JZ5 jz5 = new JZ5();
        jz5.push(1);
        jz5.push(2);
        jz5.push(3);
        System.out.println(jz5.pop());
        System.out.println(jz5.pop());
        jz5.push(4);
        System.out.println(jz5.pop());
        jz5.push(5);
        System.out.println(jz5.pop());
        System.out.println(jz5.pop());

    }

}
