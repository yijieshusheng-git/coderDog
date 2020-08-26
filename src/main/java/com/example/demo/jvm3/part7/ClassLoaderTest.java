package com.example.demo.jvm3.part7;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName ClassLoaderTest
 * @Description 不同的类加载器对 instanceof关键字运算的结果的影响
 * @Author 孤 鸿
 * @Date 2020/8/17  9:44 下午
 * @Version 1.0
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("com.example.demo.jvm3.part7.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.example.demo.jvm3.part7.ClassLoaderTest);

    }

}
