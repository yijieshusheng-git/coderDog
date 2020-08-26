package com.example.demo.niuke;

/**
 * @ClassName JZ28
 * @Description 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @Author 孤 鸿
 * @Date 2020/8/10  10:49 下午
 * @Version 1.0
 */
public class JZ28 {

    //用一般的排序也可以完成这道题目，但是如果那样完成的话就可能太简单了。
    //用preValue记录上一次访问的值，count表明当前值出现的次数，如果下一个值和当前值相同那么count++；
    // 如果不同count--，减到0的时候就要更换新的preValue值了，因为如果存在超过数组长度一半的值，
    // 那么最后preValue一定会是该值
    public static int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int value = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == value) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    value = array[i];
                    count = 1;
                }
            }
        }

        ///需要判断是否真的是大于1半数，这一步骤是非常有必要的，
        // 因为我们的上一次遍历只是保证如果存在超过一半的数就是preValue，
        // 但不代表preValue一定会超过一半
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                num++;
            }
        }

        return array.length / 2 >= num ? 0 : value;

    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(MoreThanHalfNum_Solution(array));
        int[] array2 = new int[]{1, 2, 3, 2, 4, 2, 5, 2, 3};
        System.out.println(MoreThanHalfNum_Solution(array2));
        int[] array3 = new int[]{1, 2, 2, 2, 1};
        System.out.println(MoreThanHalfNum_Solution(array3));
    }
}
