package com.fanshuaiko;

import java.util.Stack;

/**
 * @ClassName Day5
 * @Author fanshuaiko
 * @Date 2019-08-06 13:45
 * @Version 1.0
 * @Question 两个栈实现队列
 * @Point 队列 栈
 * @Description 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * <p>
 * 解题思路：队列的特点是先进先出，而栈的特点是先进后出
 *          栈1出一个元素，栈2入这个元素，以此类推，最终弹出栈2的元素，就把顺序换过来了
 **/
public class Day5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        Day5 day5 = new Day5();
        day5.push(1);
        day5.push(2);
        day5.push(3);
        System.out.println(day5.pop());
        System.out.println(day5.pop());
        System.out.println(day5.pop());
    }
}
