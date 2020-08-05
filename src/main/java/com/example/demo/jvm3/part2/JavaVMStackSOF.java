package com.example.demo.jvm3.part2;

/**
 * @ClassName JavaVMStackSOF
 * @Description VM Args: -Xss128k
 * Java虚拟机测试：虚拟机栈和本地方法栈
 * 1. 线程请求深度大于虚拟机所允许的最大深度，会抛出 StackOverflowError异常
 * @Author 孤 鸿
 * @Date 2020/8/5  9:13 下午
 * @Version 1.0
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length: " + oom.stackLength);
            throw e;
        }
    }

}
