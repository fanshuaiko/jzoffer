package com.fanshuaiko;

/**
 * @ClassName Day10
 * @Author fanshuaiko
 * @Date 2019-08-08 14:35
 * @Version 1.0
 * @Question 矩形覆盖
 * @Point 递归
 * @Description 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 **/
public class Day10 {
    /**
     * 和跳台阶类似，都是递归
     * 3种解法可参照斐波那契数列那道题
     * 此处就只列出递归解法
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if(target<3){
            return target;
        }
        return RectCover(target-1)+RectCover(target-2);
    }

    public static void main(String[] args) {
        Day10 day10 = new Day10();
        System.out.println(day10.RectCover(5));
    }
}
