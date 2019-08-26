package com.fanshuaiko;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @ClassName Day22
 * @Author fanshuaiko
 * @Date 2019-08-26 14:01
 * @Version 1.0
 * @Question 从上往下打印二叉树
 * @Point
 * @Description 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 **/
public class Day22 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        list.add(root);
        while (list.size() != 0) {
            TreeNode treeNode = list.removeFirst();
            if (treeNode.left != null) {
                list.add(treeNode.left);
            }
            if (treeNode.right != null) {
                list.add(treeNode.right);
            }
            result.add(treeNode.val);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode right = treeNode.right = new TreeNode(2);
        TreeNode left = treeNode.left = new TreeNode(3);
        right.left = new TreeNode(4);
        System.out.println(new Day22().PrintFromTopToBottom(treeNode));
    }
}
