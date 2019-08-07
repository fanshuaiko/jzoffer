package com.fanshuaiko;

/**
 * @ClassName Day6
 * @Author fanshuaiko
 * @Date 2019-08-07 09:04
 * @Version 1.0
 * @Question 旋转数组的最小数字
 * @Point 查找 数组
 * @Description 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * <p>
 * 解题思路：
 *          二分法，因为是非减排序，所以
 *          如果array[mid]大于array[high],说明最小值在右边，再对右边进行二分查找
 *          如果array[mid]小于array[high],说明最小值在左边，再对左边进行二分查找
 **/
public class Day6 {
    public int minNumberInRotateArray(int[] array) {
        int high = array.length - 1;
        int low = 0;
        int mid;
        if (array.length == 0) {
            return 0;
        }
        while (low < high) {
            mid = low + (high - low) / 2;
            if (array[mid] > array[high]) {
                low = mid + 1;
            } else if (array[mid] < array[high]) {
                high = mid;
            } else {
                high = high - 1;
            }
        }
        return array[low];
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 2, 2};
        int array1 = new Day6().minNumberInRotateArray(array);
        System.out.println(array1);
    }
}
