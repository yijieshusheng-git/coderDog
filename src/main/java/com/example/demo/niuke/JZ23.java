package com.example.demo.niuke;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName JZ23
 * @Description 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * @Author 孤 鸿
 * @Date 2020/8/3  4:47 下午
 * @Version 1.0
 */
public class JZ23 {

    //链接：https://www.nowcoder.com/questionTerminal/a861533d45854474ac791d90e447bafd?answerType=1&f=discussion
    //来源：牛客网
    //
    //发现对于每一棵子树，它的根结点总是对应该子树的后序序列的最后一个数
    //
    //那么，只需要不断地确定出左子树区间和右子树区间，并且判断：左子树区间的所有结点值 < 根结点值 < 右子树区间所有结点值，
    // 这个条件是否满足即可
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        return bst(sequence);
    }

    static boolean bst(int[] sequence) {
        if (sequence == null || sequence.length == 0 || sequence.length == 1) {
            return true;
        }

        int root = sequence[sequence.length - 1];
        int i;
        //找到左子树,右子树的分界点
        for (i = 0; i < sequence.length; i++) {
            if (root < sequence[i]) {
                break;
            }
        }

        if (i == sequence.length) {
            return true;
        }

        int[] left = new int[i];
        int[] right = new int[sequence.length - i - 1];
        for (int s = 0; s < i; s++) {
            left[s] = sequence[s];
        }


        int q = 0;
        for (int j = i; j < sequence.length - 1; ++j) {
            right[q++] = sequence[j];
            if (root > sequence[j]) {
                return false;
            }
        }

        return bst(left) && bst(right);
    }

    public static void main(String[] args) {
        int[] aa = new int[]{4, 6, 7, 5};
        System.out.println(VerifySquenceOfBST(aa));
        int[] bb = new int[]{4, 8, 6, 12, 16, 14, 10};
        System.out.println(VerifySquenceOfBST(bb));
        int[] cc = new int[]{5, 4, 3, 2, 1};
        System.out.println(VerifySquenceOfBST(cc));
        int[] dd = new int[]{};
        System.out.println(VerifySquenceOfBST(dd));
    }

}
