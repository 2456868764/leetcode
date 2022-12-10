package com.jun.study.leetcode.recursion;

import com.jun.study.leetcode.tree.TreeNode;

/**
 *  https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 */
public class MaximumDepth {

    public int maxDepth(TreeNode root) {
        return maxDepthRecurion(root, 0);
    }

    private int maxDepthRecurion(TreeNode root, int i) {
        if (root == null) {
            return i;
        }
        return Math.max(maxDepthRecurion(root.left, i + 1), maxDepthRecurion(root.right, i + 1));
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node5.left = node1;
        node5.right = node7;
        node7.left = node6;
        node7.right = node8;
        MaximumDepth maximumDepth = new MaximumDepth();
        System.out.println("max depth=" + maximumDepth.maxDepth(node5));
    }

}
