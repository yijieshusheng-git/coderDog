package com.example.demo.niuke;

import java.util.Stack;

/**
 * @ClassName JZ21
 * @Description 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * @Author 孤 鸿
 * @Date 2020/8/2  10:05 上午
 * @Version 1.0
 */
public class JZ21 {

    //链接：https://www.nowcoder.com/questionTerminal/d77d11405cc7470d82554cb392585106?answerType=1&f=discussion
    //来源：牛客网
    //
    //直接模拟即可。因为弹出之前的值都会先入栈，所以这里用个栈来辅助。
    //
    //初始化：用指针i指向pushV的第一个位置， 指针j指向popV的第一个位置
    //如果pushV[i] != popV[j]， 那么应该将pushV[i]放入栈中， ++i
    //否则，pushV[i]==popV[j], 说明这个元素是放入栈中立马弹出，所以，++i, ++j，然后应该检查popV[j]
    //与栈顶元素是否相等，如果相等，++j, 并且弹出栈顶元素
    //4，重复2，3， 如果i==pushV.size(), 说明入栈序列访问完，此时检查栈是否为空，如果为空，说明匹配，斗则不匹配。
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        if(popA.length == 0 || pushA.length != popA.length){
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int i=0,j=0;
        while(i < pushA.length){
            if(pushA[i] == popA[j]){
                ++i;
                ++j;
                while(!stack.isEmpty()&& stack.peek() == popA[j]){
                    stack.pop();
                    j++;
                }
            }else{
                stack.push(pushA[i++]);
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushA = new int[]{1,2,3,4,5};
        int[] popA = new int[]{4,5,3,2,1};
        int[] popA2 = new int[]{4,3,5,1,2};
        System.out.println(IsPopOrder(pushA,popA));
        System.out.println(IsPopOrder(pushA,popA2));
    }

}
