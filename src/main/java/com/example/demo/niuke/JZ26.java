package com.example.demo.niuke;

/**
 * @ClassName JZ26
 * @Description 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @Author 孤 鸿
 * @Date 2020/8/4  6:28 下午
 * @Version 1.0
 */
public class JZ26 {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 二叉搜索树的性质是：左节点 < 当前节点 < 右节点。转换后的双向链表是有序的，这里采用中序递归遍历保证有序性。
     * 设计的递归函数返回的是：已转换好的双向链表的尾结点，也就是当前节点的 left 指针应该指向的地方。递归函数的实现思路：
     * 检查 left 是否为空，不为空，那么递归调用（传入左子树）
     * 将 left 指针指向已转换好的双向链表的尾结点，并将尾节点的 right 指向当前节点
     * 更新双向链表尾节点（变为当前节点），检查 right 是否为空，不为空，递归调用（传入右子树）
     * 返回转换后的双向链表尾节点
     *
     * @param pRootOfTree
     * @return com.example.demo.niuke.JZ26.TreeNode
     * @author 孤 鸿
     * @CreateDate 6:38 下午 2020/8/5
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }

        ConvertDetail(pRootOfTree, null);
        while (pRootOfTree.left != null) {
            pRootOfTree = pRootOfTree.left;
        }

        return pRootOfTree;
    }


    TreeNode ConvertDetail(TreeNode pRootOfTree, TreeNode lastNode) {
        if (pRootOfTree == null) {
            return pRootOfTree;
        }

        if (pRootOfTree.left != null) {
            lastNode = ConvertDetail(pRootOfTree.left, lastNode);
        }

        pRootOfTree.left = lastNode;
        if (lastNode != null) {
            lastNode.right = pRootOfTree;
        }

        lastNode = pRootOfTree;
        if (pRootOfTree.right != null) {
            lastNode = ConvertDetail(pRootOfTree.right, lastNode);
        }

        return lastNode;
    }


}
