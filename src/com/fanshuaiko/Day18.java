package com.fanshuaiko;

/**
 * @ClassName Day18
 * @Author fanshuaiko
 * @Date 2019-08-14 16:17
 * @Version 1.0
 * @Question 二叉树的镜像
 * @Point 树
 * @Description 操作给定的二叉树，将其变换为源二叉树的镜像。
 * <p>
 * 二叉树的镜像定义：源二叉树
 * 8
 * /  \
 * 6   10
 * / \  / \
 * 5  7 9 11
 * 镜像二叉树
 * 8
 * /  \
 * 10   6
 * / \  / \
 * 11 9 7  5
 **/
public class Day18 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 使用递归，每次都对一个节点的左右节点进行互换
      * @param root
     */
    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        TreeNode tmp;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        //如果左节点不为空，对左节点的左右节点进行互换
        if (root.left != null) {
            Mirror(root.left);
        }
        //如果右节点不为空，对左节点的左右节点进行互换
        if (root.right != null) {
            Mirror(root.right);
        }

    }

    /**
     * root1:
     *      8
     *     7 9
     *    8 1
     **/
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        TreeNode treeNode1 = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(8);
        TreeNode treeNode4 = new TreeNode(1);
        root1.left = treeNode1;
        root1.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        Day18 day18 = new Day18();
        day18.Mirror(root1);
    }
}
