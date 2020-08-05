package com.example.demo.niuke;

import java.util.ArrayList;

/**
 * @ClassName JZ24
 * @Description 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * @Author 孤 鸿
 * @Date 2020/8/4  10:32 上午
 * @Version 1.0
 */
public class JZ24 {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    //树的深度优先遍历  前序遍历
    //总结：
    //    FindPath(TreeNode root, int target)解决的问题是找到以root为根的树，和为target的路径。
    //    要解决这个问题，需要以下步骤
    //        1.以左孩子为根的树，和为target-root.val的路径（子问题）
    //        2.以右孩子为根的树，和为target-root.val的路径（子问题）
    //        3.遍历1、2两步得到的路径结果，然后将root.val插到路径结果最前面
    //    可以看出这个问题的结果可以由其子问题的结果合并得到，所以可以使用递归来解决。
    //    最后需要注意按照路径长度从大到小排序一下路径，参照归并排序合并有序元素时的思想即可。
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private ArrayList<Integer> onePath = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return result;
        }

        onePath.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(onePath));
        }

        FindPath(root.left, target);
        FindPath(root.right, target);

        onePath.remove(onePath.size() - 1);
        return result;
    }

}
