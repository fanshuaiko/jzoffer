package com.fanshuaiko;

/**
 * @ClassName Day8
 * @Author fanshuaiko
 * @Date 2019-08-08 13:16
 * @Version 1.0
 * @Question 跳台阶
 * @Point 递归
 * @Description 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * <p>
 * 解题思路：
 * 本题和斐波那契数列那道题是一样的，都是f(n)=f(n-1)+f(n-2)
 * 所以斐波那契数列的三种解法都是和这道题，这里就只列举递归这种解法
 **/
public class Day8 {
    public int JumpFloor(int target) {
        if (target <= 1) {
            return target;
        }
        if (target == 2) {
            return 2;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    public static void main(String[] args) {
        Day8 day8 = new Day8();
        System.out.println(day8.JumpFloor(3));
    }
}
