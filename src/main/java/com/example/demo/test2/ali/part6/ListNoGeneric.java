package com.example.demo.test2.ali.part6;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ListNoGeneric
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/22  11:51 下午
 * @Version 1.0
 */
public class ListNoGeneric {

    public static void main(String[] args) {
        List a1 = new ArrayList();
        a1.add(new Object());
        a1.add(new Integer(111));
        a1.add(new String("hello 111"));

        List<Object> a2 = a1;
        a2.add(new Object());
        a2.add(new Integer(222));
        a2.add(new String("hello 222"));

        List<Integer> a3 = a1;
        a3.add(new Integer(333));
      //  a3.add(new Object());
       // a3.add(new String("hello 333"));

       List<?> a4 = a1;
       a4.remove(0);
       a4.clear();
      // a4.add(new Object());
    }

}


