package com.example.demo.niuke;

/**
 * @ClassName JZ6
 * @Description 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @Author 孤 鸿
 * @Date 2020/7/25  4:39 下午
 * @Version 1.0
 */
public class JZ6 {

    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int minValue = array[0];
        for (int i = 0; i < array.length; i++) {
            minValue = Math.min(minValue, array[i]);
        }

        return minValue;
    }

    //二分查找的变种方法
    public static int minNumberInRotateArray2(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int left = 0, right = array.length - 1;
        int mid = 0;
        int target = array[right];
        while (left <= right) {
            mid = (left + right) / 2;
            //结果在左边
            if (array[mid] < target) {
                right = mid;
                target = array[right];
            } else if (array[mid] > target) {
                //结果在右边
                left = mid + 1;
            } else {
                //结果不确定
                target = array[--right];
            }
        }

        return array[mid];
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 5, 1, 2};
        System.out.println(minNumberInRotateArray(array));
        System.out.println(minNumberInRotateArray2(array));
    }
}
