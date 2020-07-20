package com.example.demo.test2.ali;

import java.io.FileNotFoundException;

/**
 * @ClassName CustomClassLoader
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/12  4:17 下午
 * @Version 1.0
 */
public class CustomClassLoader extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try{
            byte[] result = getClassFromCustomPath(name);
            if(result == null){
                throw new FileNotFoundException();
            }else {
                return defineClass(name,result,0,result.length);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        throw new ClassNotFoundException();
    }

    private byte[] getClassFromCustomPath(String name) {
     return  null;
    }
}
