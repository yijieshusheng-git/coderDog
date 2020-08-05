package com.example.demo.niuke;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JZ25
 * @Description 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点）
 * ，请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * @Author 孤 鸿
 * @Date 2020/8/4  2:56 下午
 * @Version 1.0
 */
public class JZ25 {

    static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        //保存复制出来的节点之间的映射关系
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode temp = pHead;

        //新建对应节点并赋值，
        while (temp != null) {
            RandomListNode newNode = new RandomListNode(temp.label);
            map.put(temp, newNode);
            temp = temp.next;
        }

        //节点之间的关系赋值(next,random)
        temp = pHead;
        while (temp != null) {
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(pHead);
    }

}
