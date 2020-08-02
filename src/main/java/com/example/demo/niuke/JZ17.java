package com.example.demo.niuke;

/**
 * @ClassName JZ17
 * @Description 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @Author 孤 鸿
 * @Date 2020/8/1  6:29 下午
 * @Version 1.0
 */
public class JZ17 {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        //如果根节点就是和子树的根节点值相同的话,尝试一次
        if (root1.val == root2.val) {
            if (whetherIsSameTree(root1, root2)) {
                return true;
            }
        }

        //遍历左右子树
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    boolean whetherIsSameTree(TreeNode root, TreeNode subTree) {
        //子树匹配完成，
        if (subTree == null) {
            return true;
        }
        //大树匹配完成，是false
        if (root == null) {
            return false;
        }

        if (root.val == subTree.val) {
            return whetherIsSameTree(root.left, subTree.left) &&
                    whetherIsSameTree(root.right, subTree.right);
        }

        //找到一个值和子树根节点相同的结点开始分别左右递归比较下去
        return false;
    }

}