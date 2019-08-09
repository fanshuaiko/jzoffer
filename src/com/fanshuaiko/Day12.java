package com.fanshuaiko;

/**
 * @ClassName Day12
 * @Author fanshuaiko
 * @Date 2019-08-08 15:50
 * @Version 1.0
 * @Question 数值的整数次方
 * @Point 数学，快速幂算法
 * @Description 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 **/
public class Day12 {

    /**
     * 写出指数的二进制表达，例如13表达为二进制1101。
     * 举例:10^1101 = 10^0001*10^0100*10^1000。
     * 通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        double res = 1;
        int n = exponent;
        if (exponent < 0) {
            exponent = -exponent;
        } else if (exponent == 0) {
            return 1;
        }
        while (exponent != 0) {
            if ((exponent & 1) == 1) {
                res *= base;
            }
            base *= base;
            exponent >>= 1;
        }

        return n > 0 ? res : (1 / res);
    }

    public static void main(String[] args) {
        Day12 day12 = new Day12();
        System.out.println(day12.Power(2, 5));
    }
}
