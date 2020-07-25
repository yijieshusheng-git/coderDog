package com.example.demo.niuke;

/**
 * @ClassName JZ1
 * <p>
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/25  1:45 下午
 * @Version 1.0
 */
public class JZ1 {

    public static void main(String[] args) {
        //7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]

        int[] row1 = new int[]{1, 2, 8, 9};
        int[] row2 = new int[]{2, 4, 9, 12};
        int[] row3 = new int[]{4, 7, 10, 13};
        int[] row4 = new int[]{6, 8, 11, 15};
        int[][] array = new int[][]{row1, row2, row3, row4};
        //System.out.println(find2(7, array));

        int[] row5 = new int[]{1, 2, 8, 9};
        int[] row6 = new int[]{4, 7, 10, 13};
        int[][] array2 = new int[][]{row5, row6};
        System.out.println(find2(7, array2));
    }

    static boolean find2(int target, int[][] array) {
        int lenRow = array.length;
        int lenColumn = array[0].length;

        //二位数组的二分查找 左上角 右下角
        int x = lenRow -1,y = 0;
        while(x >=0 && y <= lenColumn-1){
            if(array[x][y] == target){
                return true;
            }else if(array[x][y] < target){
                y++;
            }else if(array[x][y] > target){
                x--;
            }
        }

        return false;
    }

}
