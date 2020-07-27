package com.example.demo.niuke;

/**
 * @ClassName JZ15
 * @Description 输入一个链表，反转链表后，输出新链表的表头。
 * @Author 孤 鸿
 * @Date 2020/7/27  10:36 下午
 * @Version 1.0
 */
public class JZ15 {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tailNode = head;
        while (tailNode.next != null) {
            tailNode = tailNode.next;
        }

        ListNode newHead = head;
        ListNode temp = null;
        while (newHead != tailNode){
            //将要被移动的结点
            temp = newHead;

            //新头结点后移
            newHead = newHead.next;

            //新加入的结点放到尾结点后面,作为整个链表的第二个结点
            temp.next = tailNode.next;
            tailNode.next = temp;
        }
        //移动len - 1个，此时原来的尾结点就会变成新的头结点
        return tailNode;
    }


}
