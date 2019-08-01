package com.fanshuaiko;

/**
 * @ClassName Day2
 * @Author fanshuaiko
 * @Date 19-8-1 上午11:02
 * @Version 1.0
 * @Question 替换空格
 * @Point 字符串
 * @Description 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 **/
public class Day2 {

    /**
     * 直接使用String自带的方法replaceAll
     *
     * @param str
     * @return
     */
    public static String replaceSpace1(StringBuffer str) {
        String result = str.toString().replaceAll(" ", "%20");
        return result;
    }

    /**
     * 将字符串转为char数组，遍历，再将其拼接到新的字符串中，若为空格就替换为%20
     * @param str
     * @return
     */
    public static String replaceSpace2(StringBuffer str) {
        char[] chars = str.toString().toCharArray();
        StringBuilder result = new StringBuilder();
        for (char aChar : chars) {
            if (' ' == aChar) {
                result.append("%20");
            } else {
                result.append(aChar);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String str = replaceSpace2(new StringBuffer("We are Happy"));
        System.out.println(str);
    }
}
