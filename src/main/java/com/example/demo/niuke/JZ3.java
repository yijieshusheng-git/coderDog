package com.example.demo.niuke;

import java.util.ArrayList;

/**
 * @ClassName JZ3
 * @Description 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * @Author 孤 鸿
 * @Date 2020/7/31  8:46 上午
 * @Version 1.0
 */
public class JZ3 {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }

        ListNode temp = listNode;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        int p = 0, q = list.size()-1;
        while (p <= q - 1) {
            int number = list.get(p);
            list.set(p, list.get(q));
            list.set(q, number);
            p++;
            q--;
        }

        return list;
    }

}



