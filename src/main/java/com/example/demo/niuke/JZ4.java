package com.example.demo.niuke;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName JZ4
 * @Description 输入某二叉树的前序遍历和中序遍历的结果，
 * 请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @Author 孤 鸿
 * @Date 2020/7/31  2:55 下午
 * @Version 1.0
 */
public class JZ4 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (in.length == 0 || pre.length != in.length) {
            return null;
        }

        int len = in.length;
        int val = pre[0];
        TreeNode root = new TreeNode(val);
        if (len == 1) {
            return root;
        }

        int p = 0;
        for (int i = 0; i < len; i++) {
            if (val == in[i]) {
                p = i;
                break;
            }
        }

        int[] preLeft = new int[p];
        int[] preRight = new int[len - p - 1];
        int[] inLeft = new int[p];
        int[] inRight = new int[len - p - 1];

        for (int i = 1; i < len; i++) {
            if (i <= p) {
                preLeft[i - 1] = pre[i];
                continue;
            }
            preRight[i - p - 1] = pre[i];
        }

        for (int i = 0; i < len; i++) {
            if (i < p) {
                inLeft[i] = in[i];
            } else if (i > p) {
                inRight[i - p - 1] = in[i];
            }
        }

        root.left = reConstructBinaryTree(preLeft, inLeft);
        root.right = reConstructBinaryTree(preRight, inRight);
        return root;
    }

    public static void main(String[] args) {
        int pre[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int in[] = new int[]{3, 2, 4, 1, 6, 5, 7};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
        //{1,2,5,3,4,6,7}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);


        TreeNode temp;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (temp == null) {
                continue;
            }
            System.out.print(temp.val + " ");
            queue.offer(temp.left);
            queue.offer(temp.right);
        }
    }

}
