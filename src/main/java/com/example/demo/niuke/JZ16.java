package com.example.demo.niuke;

/**
 * @ClassName JZ16
 * @Description 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @Author 孤 鸿
 * @Date 2020/7/27  11:14 下午
 * @Version 1.0
 */
public class JZ16 {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode node = list1;
        ListNode node2 = list2;
        ListNode headNode;

        //找到第一个头结点
        if (list1.val <= list2.val) {
            headNode = list1;
            node = list1.next;
            list1.next = null;
        } else {
            headNode = list2;
            node2 = list2.next;
            list2.next = null;
        }

        ListNode temp;
        ListNode tailNode = headNode;
        while (node != null && node2 != null) {
            if (node.val <= node2.val) {
                temp = node;
                node = node.next;
            } else {
                temp = node2;
                node2 = node2.next;
            }

            temp.next = tailNode.next;
            tailNode.next = temp;
            tailNode = tailNode.next;
        }

        if (node != null) {
            tailNode.next = node;
        }
        if (node2 != null) {
            tailNode.next = node2;
        }

        return headNode;
    }

}
