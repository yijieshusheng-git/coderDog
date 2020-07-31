package com.example.demo.niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName JZ20
 * @Description 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * @Author 孤 鸿
 * @Date 2020/7/30  11:26 下午
 * @Version 1.0
 */
public class JZ20 {

    Stack<Integer> stack = new Stack<>();
    List<Integer> minList = new ArrayList<>();

    public void push(int node) {
        minList.add(node);
        minList.sort(Integer::compareTo);
        stack.push(node);
    }

    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        int pop = stack.pop();
        handlerList(pop);
    }

    public int top() {
        int peek = stack.peek();
        handlerList(peek);
        return peek;
    }

    public int min() {
        return minList.get(0);

    }

    void handlerList(int pop) {
        int i;
        for (i = 0; i < minList.size(); i++) {
            if (pop == minList.get(i)) {
                break;
            }
        }
        minList.remove(i);
        minList.sort(Integer::compareTo);
    }

}