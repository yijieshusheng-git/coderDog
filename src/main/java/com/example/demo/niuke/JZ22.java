package com.example.demo.niuke;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName JZ22
 * @Description 从上往下打印出二叉树的每个节点，同层节点从左至右打印
 * @Author 孤 鸿
 * @Date 2020/7/29  10:53 下午
 * @Version 1.0
 */
public class JZ22 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        queue.offer(root);
        TreeNode temp;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if(temp == null){
                continue;
            }
            result.add(temp.val);
            queue.offer(temp.left);
            queue.offer(temp.right);
        }
        return result;
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
