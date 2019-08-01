package com.fanshuaiko;

/**
 * @ClassName Day1
 * @Author fanshuaiko
 * @Date 19-7-31 下午7:05
 * @Version 1.0
 * @Question 二维数组中的查找
 * @Point 数组
 * @Description 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 解题思路：
 *          将这二维数组看成矩阵，该矩阵从左到右递增，从上到下递增
 *          所以我们以右上角的点为起始点与target作比较，
 *          如果target比它大，就往下移
 *          如果target比它小，就往左移
 *          以此类推
 *
 **/
public class Day1 {

    public static boolean find(int target, int[][] array) {

        int x = array.length;
        int y = array[0].length;
        int i = 0;
        int j = y - 1;
        while (i < x && j >= 0) {
            if (target<array[i][j]) {
                j--;
            }else if(target>array[i][j]){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int array[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int a[][] = {};
        System.out.println(find(7, array));
    }

}
