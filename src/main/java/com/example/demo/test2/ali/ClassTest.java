package com.example.demo.test2.ali;

import sun.misc.Launcher;

import java.lang.reflect.Field;
import java.net.URL;

/**
 * @ClassName ClassTest
 * @Description 第四章 Class Test
 * @Author 孤 鸿
 * @Date 2020/7/12  3:33 下午
 * @Version 1.0
 */
public class ClassTest {

    private static int[] array = new int[3];
    private static int length = array.length;

    private static Class<One> one = One.class;
    private static Class<Another> another = Another.class;

    public static void main(String[] args) throws Exception {
        One oneObject = one.newInstance();
        oneObject.call();

        Another anotherObject = another.newInstance();
        anotherObject.speak();

        Field privateFieldOne = one.getDeclaredField("inner");
        privateFieldOne.setAccessible(true);
        privateFieldOne.set(oneObject, "world changed");
        System.out.println(oneObject.getInner());

        ClassLoader c = ClassTest.class.getClassLoader();
        System.out.println(c);
        ClassLoader c2 = c.getParent();
        System.out.println(c2);
        ClassLoader c3 = c2.getParent();
        System.out.println(c3);

        //打印 Bootstrap 所以已经加载的类库
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (java.net.URL url : urLs){
            System.out.println(url.toExternalForm());
        }

    }

}

class One {
    private String inner = "time files";

    public String getInner() {
        return inner;
    }

    public void call() {
        System.out.println("hello world");
    }
}

class Another {
    public void speak() {
        System.out.println("easy coding");
    }
}