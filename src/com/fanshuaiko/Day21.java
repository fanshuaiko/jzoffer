package com.fanshuaiko;

import java.util.Stack;

/**
 * @ClassName Day21
 * @Author fanshuaiko
 * @Date 2019-08-26 10:24
 * @Version 1.0
 * @Question 栈的压入、弹出序列
 * @Point 栈
 * @Description 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 **/
public class Day21 {
    /**
     * 利用一个辅助栈，将压入队列依次入栈，当入栈元素和弹出序列元素相等时，将该元素出栈，flag标识位后移一位，如此循环，如果最后栈为空说明，弹出序列是入栈序列的弹出序列
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length<=0||popA.length<=0){
            return false;
        }
        //辅助栈
        Stack<Integer> stack = new Stack<>();
        //标识出栈序列位置
        int flag  = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while(!stack.empty()&&stack.peek()==popA[flag]){
                //出栈
                stack.pop();
                //标识往后移一位
                flag++;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {

        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,2,1};
        int[] popB = {4,5,2,1,3};
        Day21 day21 = new Day21();
        System.out.println(day21.IsPopOrder(pushA, popA));
        System.out.println(day21.IsPopOrder(pushA, popB));
    }
}
