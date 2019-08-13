package com.fanshuaiko;

/**
 * @ClassName Day16
 * @Author fanshuaiko
 * @Date 2019-08-13 09:45
 * @Version 1.0
 * @Question 合并两个排序的链表
 * @Point 链表
 * @Description 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 **/
public class Day16 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 将list1和list2依次进行比较，较小者放入新的list中
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1, ListNode list2) {

        ListNode head=new ListNode(-1);
        head.next=null;
        ListNode root=head;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                head.next=list1;
                head=list1;
                list1=list1.next;
            }else{
                head.next=list2;
                head=list2;
                list2=list2.next;
            }
        }
        //把未结束的链表连接到合并后的链表尾部
        if(list1!=null){
            head.next=list1;
        }
        if(list2!=null){
            head.next=list2;
        }
        return root.next;
    }

    public static void main(String[] args) {
        Day16 day16 = new Day16();
        ListNode listNode = new ListNode(10);
        ListNode listNode1 = new ListNode(11);
        listNode.next = listNode1;
        ListNode listNode2 = new ListNode(12);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(13);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(14);
        listNode3.next = listNode4;

        ListNode secListNode = new ListNode(10);
        ListNode secListNode1 = new ListNode(12);
        secListNode.next = secListNode1;
        ListNode secListNode2 = new ListNode(13);
        secListNode1.next = secListNode2;
        System.out.println(day16.Merge(listNode, secListNode));
    }
}
