package com.example.demo.niuke;

import java.util.ArrayList;

/**
 * @ClassName JZ19
 * @Description 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
 * 如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @Author 孤 鸿
 * @Date 2020/7/28  7:37 下午
 * @Version 1.0
 */
public class JZ19 {

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> resultList = new ArrayList<>();
        if (matrix.length == 0) {
            return resultList;
        }

        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (true) {
            for (int i = left; i <= right; i++) {
                resultList.add(matrix[up][i]);
            }
            up++;
            if (up > down) {
                break;
            }

            for (int i = up; i <= down; i++) {
                resultList.add(matrix[i][right]);
            }
            right--;
            if (right < left) {
                break;
            }

            for (int i = right; i >= left; i--) {
                resultList.add(matrix[down][i]);
            }
            down--;
            if (down < up) {
                break;
            }

            for (int i = down; i >= up; i--) {
                resultList.add(matrix[i][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }

        return resultList;
    }

    public static void main(String[] args) {

        int[] r1 = new int[]{1, 2, 3, 4};
        int[] r2 = new int[]{5, 6, 7, 8};
        int[] r3 = new int[]{9, 10, 11, 12};
        int[] r4 = new int[]{13, 14, 15, 16};
        int[][] matrix = new int[][]{r1, r2, r3, r4};
        ArrayList<Integer> result = printMatrix(matrix);
        result.forEach(n -> System.out.print(n + " "));
    }

}
