package com.example.demo.test2.ali.part6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName ArrayListFailFast
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/24  11:13 下午
 * @Version 1.0
 */
public class ArrayListFailFast {

  /*  public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
       *//* for (String s : list) {
            if ("two".equals(s)) {
                list.remove(s);
            }
        }*//*

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            synchronized (ArrayListFailFast.class){
                String s = iterator.next();
                if ("two".equals(s)) {
                    list.remove(s);
                }
            }
        }

        System.out.println(list);
    }*/

    public static void main(String[] args) {
  List<String> list = new ArrayList<>();
  for (int i = 0 ; i < 10 ; i++ ) {
    list.add(i + "");
  }
  Iterator<String> iterator = list.iterator();
  int i = 0 ;
  while(iterator.hasNext()) {
    if (i == 3) {
      list.remove(3);
    }
    System.out.println(iterator.next());
    i ++;
  }
    }
}
