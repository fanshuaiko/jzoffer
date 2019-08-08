package com.fanshuaiko;

/**
 * @ClassName Day9
 * @Author fanshuaiko
 * @Date 2019-08-08 13:32
 * @Version 1.0
 * @Question 变态跳台阶
 * @Point 贪心
 * @Description 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 **/
public class Day9 {
    /**
     * 跳上n级的跳法等于跳一级的跳法+跳二级的跳法+跳三级的跳法+。。。。。。
     * f(n) = f(n-1)+f(n-2)+f(n-3)+ ... +f(2)+f(1)+f(0)
     * f(n-1) = f(n-2)+f(n-3)+ ... +f(2)+f(1)+f(0)
     * f(n) = 2f(n-1)
     *
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        if(target<3){
            return target;
        }
        return 2*JumpFloorII(target-1);
    }

    public static void main(String[] args) {
        Day9 day9 = new Day9();
        System.out.println(day9.JumpFloorII(3));
    }
}
