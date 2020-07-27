package com.example.demo.niuke;

/**
 * @ClassName JZ13
 * @Description 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @Author 孤 鸿
 * @Date 2020/7/27  9:26 下午
 * @Version 1.0
 */
public class JZ13 {

    public static void reOrderArray(int[] array) {
        if (array.length == 0) {
            return;
        }
        int[] temp = new int[array.length];
        int a = 0;

        for (int i = 0; i < array.length; ++i) {
            if (array[i] % 2 == 1) {
                temp[a++] = array[i];
            }
        }
        for (int i = 0; i < array.length; ++i) {
            if (array[i] % 2 == 0) {
                temp[a++] = array[i];
            }
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = temp[i];
        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        reOrderArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
    }

    static void reOrderArray2(int[] array){
        if(array.length == 0){
            return;
        }

        int oddCount = 0;
        for (int i = 0; i < array.length; i++) {
            oddCount++;
        }
        int p = 0;
        while(p <= oddCount){

        }

    }

}
