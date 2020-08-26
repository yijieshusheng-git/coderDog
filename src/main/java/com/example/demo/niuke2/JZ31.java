package com.example.demo.niuke2;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JZ31
 * @Description 求出1~13的整数中1出现的次数,
 * 并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数
 * （从1 到 n 中1出现的次数）。
 * @Author 孤 鸿
 * @Date 2020/8/17  11:53 下午
 * @Version 1.0
 */
public class JZ31 {

    public static int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0) {
            return 0;
        }

        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(String.valueOf(i));
        }

        byte[] bytes = String.join("", list).getBytes();
        int count = 0;
        for (byte aByte : bytes) {
            if ('1' == aByte) {
                count++;
            }
        }

        return count;
    }

    public static int NumberOf1Between1AndN_Solution2(int n) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            byte[] bytes = String.valueOf(i).getBytes();
            for (byte aByte : bytes) {
                if ('1' == aByte) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(13));
        System.out.println(NumberOf1Between1AndN_Solution(14));
        System.out.println(NumberOf1Between1AndN_Solution2(13));
        System.out.println(NumberOf1Between1AndN_Solution2(14));
    }

}
