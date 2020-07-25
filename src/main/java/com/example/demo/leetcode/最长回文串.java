package com.example.demo.leetcode;


import java.util.*;

/**
 * @ClassName 最长回文串
 * <p>
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "abccccdd"
 * <p>
 * 输出:
 * 7
 * <p>
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/25  12:30 下午
 * @Version 1.0
 */
public class 最长回文串 {

    public static int longestPalindrome(String s) {
        int longest = 0;
        if (s == null || "".equals(s) || s.length() >= 1010) {
            return longest;
        }

        //1.分别统计每个字符出现的数量
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            if (!map.containsKey(aChar)) {
                map.put(aChar, 1);
            } else {
                map.put(aChar, map.get(aChar) + 1);
            }
        }

        Collection<Integer> values = map.values();
        if (values.stream().anyMatch(n -> 1 == n)) {
            longest++;
        }

        //如果不存在单个字符的情况，那么就要考虑特殊情况，列表里面是否含有奇数个字符的情况，有的话，总数默认+1
        if (longest == 0 && values.stream().anyMatch(n -> n % 2 == 1)) {
            longest++;
        }

        longest += values.stream().mapToInt(n -> (n / 2) * 2).sum();
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome("Aa"));
        System.out.println(longestPalindrome("ccc"));

    }

}
