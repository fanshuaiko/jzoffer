package com.fanshuaiko;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @ClassName Day24
 * @Author fanshuaiko
 * @Date 2019-08-27 10:06
 * @Version 1.0
 * @Question 二叉树中和为某一值的路径
 * @Point 树
 * @Description 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 **/
public class Day24 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
    ArrayList<Integer> list =new ArrayList<> ();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return resultList;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            resultList.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        return resultList;
    }

    public static void main(String[] args) {
        Day24 day24 = new Day24();
        TreeNode treeNode = new TreeNode(1);
        TreeNode right = treeNode.right = new TreeNode(2);
        TreeNode left = treeNode.left = new TreeNode(3);
        right.left = new TreeNode(4);
        System.out.println(day24.FindPath(treeNode, 7));
    }
}
