package com.example.demo.jvm3.part2;

/**
 * @ClassName RuntimeConstantPoolOOM
 * @Description JDK8 String.intern() 返回测试  jdk1.8.0_241.jdk
 * @Author 孤 鸿
 * @Date 2020/8/5  9:48 下午
 * @Version 1.0
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

        String str3 = new StringBuilder("ja").append("va11").toString();
        System.out.println(str3.intern() == str3);
    }

}
