package com.fanshuaiko;

/**
 * @ClassName Day14
 * @Author fanshuaiko
 * @Date 2019-08-12 11:40
 * @Version 1.0
 * @Question 链表中倒数第k个节点
 * @Point 链表
 * @Description 输入一个链表，输出该链表中倒数第k个结点。
 **/
public class Day14 {


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }


    }

    /**
     * p先走k步，q再走，这样p和q的距离就是k了，等p走到尽头，那么q自然就到了倒数第k个位置了。其实p和q就是相当于一把尺子，长度为k，尺子的尾部是p，头部为q。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail1(ListNode head, int k) {
        ListNode p = head, q = head;
        int i = 0;
        for (; p.next != null; i++) {
            if (i >= k - 1) {
                q = q.next;
            }
            p = p.next;
        }
        return i + 1 < k ? head : q;
    }

    /**
     * 与上面解法思路相同
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail2(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode pre = head;
        ListNode last = head;
        for (int i = 1; i < k; i++) {
            if (pre.next != null) {
                pre = pre.next;
            } else {
                return null;
            }
        }
        while (pre.next != null) {
            pre = pre.next;
            last = last.next;
        }
        return last;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        listNode.next = listNode1;
        ListNode listNode2 = new ListNode(3);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(4);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(5);
        listNode3.next = listNode4;
        Day14 day14 = new Day14();
        System.out.println(day14.FindKthToTail1(listNode, 5).val);
        System.out.println(day14.FindKthToTail2(listNode, 5).val);
    }
}

