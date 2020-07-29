package com.example.demo.niuke;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName JZ18
 * @Description 操作给定的二叉树，将其变换为源二叉树的镜像。
 * @Author 孤 鸿
 * @Date 2020/7/28  6:27 下午
 * @Version 1.0
 */
public class JZ18 {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    //递归
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }

        Mirror(root.left);
        Mirror(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    //非递归：层次遍历也就是广度遍历  在遍历树的同时交换节点的左右子节点
    public void Mirror2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return;
        }

        queue.offer(root);
        TreeNode current,temp;
        while(!queue.isEmpty()){
            current = queue.poll();
            if(current == null){
                continue;
            }
            queue.offer(current.left);
            queue.offer(current.right);

            temp = current.right;
            current.right = current.left;
            current.left = temp;
        }
    }


}
