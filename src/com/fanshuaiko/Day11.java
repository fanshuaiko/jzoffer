package com.fanshuaiko;

/**
 * @ClassName Day11
 * @Author fanshuaiko
 * @Date 2019-08-08 14:50
 * @Version 1.0
 * @Question 二进制中1的个数
 * @Point 进制转化 源码补码反码
 * @Description 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 **/
public class Day11 {
    /**
     * 将输入的数转为二进制，将二进制中的 0 全部去掉，剩下的就是 1
     * 但是显然使用API来解算法题有些投机取巧
     *
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        return Integer.toBinaryString(n).replaceAll("0", "").length();
    }

    /**
     * @param n
     * @return
     */
    public int NumberOf2(int n) {
        int sum = 0;
        while (n != 0) {
//            逐位和1做与运算，sum加结果，如果该位为1，那么运算结果为1，不为1，则运算结果为0
            sum += n & 1;
//            向右移动一位，如 111011  =》 11101
            n >>>= 1;
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
