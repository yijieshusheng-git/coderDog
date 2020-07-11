package com.example.demo.test2.ali;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;

/**
 * @ClassName Father
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/11  2:40 下午
 * @Version 1.0
 */
public class Father {

    protected Number doSomeThing(int a, Integer b,Object c) throws SQLException{
        System.out.println("Father`s doSomeThing");
        return new Integer(7);
    }
}

class Son1 extends Father{

    @Override
    public Integer doSomeThing(int a, Integer b, Object c) throws SQLClientInfoException {
        if(a == 0){
            throw  new SQLClientInfoException();
        }
        return new Integer(17);
    }
}
