package com.fanshuaiko;

/**
 * @ClassName Day17
 * @Author fanshuaiko
 * @Date 2019-08-14 09:50
 * @Version 1.0
 * @Question 树的子结构
 * @Point 二叉树
 * @Description 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 **/
public class Day17 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        //当连个节点都不为空时才进行对比
        if (root1 != null && root2 != null) {
            //当root1的节点等于root2的根节点时，就以该节点开始判断是否包含root2
            if (root1.val == root2.val) {
                result = doesNode1HasNode2(root1, root2);
            }
            //如果当前节点和root2的跟节点不相同，就让当前root1节点的左节点继续找
            if (!result) {
                result = HasSubtree(root1.left, root2);
            }
            //如果当前节点和root2的跟节点不相同，就让当前root1节点的右节点继续找
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;

    }

    public static boolean doesNode1HasNode2(TreeNode node1, TreeNode node2) {
        //如果node2遍历完，node1没有遍历完，说明node1包含node2，返回true
        if (node2 == null) {
            return true;
        }
        //如果node1遍历完了，node2没有遍历完，那说明node1肯定不包含node2，返回false
        if (node1 == null) {
            return false;
        }
        //如果node1和node2的节点的值没有对应上，那么返回false
        if (node1.val != node2.val) {
            return false;
        }
        //返回左右节点分别对比，只有左右节点都对应上，才说明node1包含node2
        return doesNode1HasNode2(node1.left, node2.left) && doesNode1HasNode2(node1.right, node2.right);
    }

    /**
     * root1:
     *      8
     *     7 9
     *    8 1
     *
     *  root2:
     *    7
     *   8  1
     * @param args
     */

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        TreeNode root2 = new TreeNode(7);
        TreeNode treeNode1 = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(8);
        TreeNode treeNode4 = new TreeNode(1);
        root1.left = treeNode1;
        root1.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        root2.left = treeNode3;
        root2.right = treeNode4;
        Day17 day17 = new Day17();
        //返回true
        System.out.println(day17.HasSubtree(root1, root2));
        //返回false
        root2.right = new TreeNode(0);
        System.out.println(day17.HasSubtree(root1, root2));

    }
}
