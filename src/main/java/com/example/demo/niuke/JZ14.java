package com.example.demo.niuke;

/**
 * @ClassName JZ14
 * @Description 输入一个链表，输出该链表中倒数第k个结点
 * @Author 孤 鸿
 * @Date 2020/7/27  10:23 下午
 * @Version 1.0
 */
public class JZ14 {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }

        ListNode node1 = head;
        int len = 1;
        while (node1.next != null) {
            len++;
            node1 = node1.next;
        }
        if (len < k) {
            return null;
        }

        node1 = head;
        for (int i = 0; i < len - k; i++) {
            node1 = node1.next;
        }
        return node1;
    }

}

