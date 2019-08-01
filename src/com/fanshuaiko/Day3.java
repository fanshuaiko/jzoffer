package com.fanshuaiko;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @ClassName Day3
 * @Author fanshuaiko
 * @Date 19-8-1 下午1:33
 * @Version 1.0
 * @Question 从头到尾打印链表
 * @Point 链表
 * @Description 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 **/
public class Day3 {


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 利用stack先进后出的特性，
     * 遍历ListNode将其val一个个放入stack中，
     * 再将stack中的val取出放入ArrayList中返回即可
     *
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    /**
     * 每步的逻辑相同且重复，那么就可以考虑使用递归
     * 递归调用到最后，最先添加到list中的是最后一个
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode != null) {
            printListFromTailToHead2(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(67);
        ListNode listNode1 = new ListNode(0);
        listNode.next = listNode1;
        ListNode listNode2 = new ListNode(24);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(58);
        listNode2.next = listNode3;
        ArrayList<Integer> result1 = printListFromTailToHead1(listNode);
        ArrayList<Integer> result2 = printListFromTailToHead1(listNode);
        System.out.println(result1);
        System.out.println(result2);
    }
}
