package com.example.demo.jvm3.part4;

/**
 * @ClassName JHSDB_TestCase
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/8/18  8:55 下午
 * @Version 1.0
 */
public class JHSDB_TestCase {

    static class Test {
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo() {
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done");
        }

    }

    private static class ObjectHolder {
    }

    public static void main(String[] args) {
        Test test = new JHSDB_TestCase.Test();
        test.foo();
    }

}
