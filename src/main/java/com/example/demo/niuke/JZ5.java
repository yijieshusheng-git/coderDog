package com.example.demo.niuke;

import java.util.Stack;

/**
 * @ClassName JZ5
 * @Description 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @Author 孤 鸿
 * @Date 2020/7/25  3:53 下午
 * @Version 1.0
 */
public class JZ5 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //["PSH1","PSH2","PSH3","POP","POP","PSH4","POP","PSH5","POP","POP"]
    //对应输出应该为:
    //1,2,3,4,5
    //你的输出为:
    //1,2,4,5,3

    //队列进站
    public void push(int node) {
        if (!stack1.isEmpty() && !stack2.isEmpty()) {
            // stack1 stack2 都不为空的情况下， 不能插入数据
            System.out.println("队列满");
        } else {
            stack1.push(node);
        }
    }

    //队列出
    public int pop() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("队列为空");
            return -1;
        }

        if (stack1.isEmpty()) {
            return stack2.pop();
        }

        if(stack2.isEmpty()){
            stack1MoveToStack2();
            return stack2.pop();
        }

        //二者都不空的话，需要先弹空stack2,然后再把stack1 进入stack2中
        return stack2.pop();

    }

    //stack1中有元素的时候，如果要出队列，就需要stack1中元素弹出来放到stack2中
    void stack1MoveToStack2() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

}
