package com.fanshuaiko;

/**
 * @ClassName Day7
 * @Author fanshuaiko
 * @Date 2019-08-07 17:58
 * @Version 1.0
 * @Question 斐波那契数列
 * @Point 递归
 * @Description 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * <p>
 * 解题思路：
 **/
public class Day7 {

    /**
     * 优点：最简单的实现方式，利用递归
     * f(n) = f(n-1)+f(n-2)
     * 缺点：会重复计算
     *
     * @param n
     * @return
     */
    public int Fibonacci1(int n) {
        if (n <= 1) {
            return n;
        }
        return Fibonacci1(n - 1) + Fibonacci1(n - 2);
    }

    /**
     * 利用数组
     * 优点：避免了多次的重复计算
     *
     * @param n
     * @return
     */
    public int Fibonacci2(int n) {
        int[] num = new int[n + 2];
        num[0] = 0;
        num[1] = 1;
        for (int i = 2; i <= n; i++) {
            num[i] = num[i - 1] + num[i - 2];
        }
        return num[n];
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int Fibonacci3(int n) {
        int a = 0;
        int b = 1;

        while (n-- > 0) {
            b = a + b;
            a = b - a;
        }
        return a;
    }

    public static void main(String[] args) {
        int fibonacci1 = new Day7().Fibonacci1(4);
        int fibonacci2 = new Day7().Fibonacci2(4);
        int fibonacci3 = new Day7().Fibonacci3(4);
        System.out.println(fibonacci1);
        System.out.println(fibonacci2);
        System.out.println(fibonacci3);
    }
}
