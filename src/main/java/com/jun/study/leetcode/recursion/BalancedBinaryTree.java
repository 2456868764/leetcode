package com.jun.study.leetcode.recursion;

import com.jun.study.leetcode.tree.TreeNode;

import java.util.Arrays;
import java.util.Collections;

/**
 * https://leetcode.cn/problems/balanced-binary-tree/solution/ping-heng-er-cha-shu-by-leetcode-solution/
 */
public class BalancedBinaryTree {
    public boolean isBalance(TreeNode root) {
        return height(root) > 0;
    }

    private  int height(TreeNode node) {
        //terminate
        if (node == null) {
            return 0;
        }
        int leftLevel = height(node.left);
        if (leftLevel < 0) {
            return -1;
        }
        int rightLevel = height(node.right);
        if (rightLevel < 0) {
            return -1;
        }
        if (Math.abs(leftLevel - rightLevel) > 1) {
            return -1;
        }

        Collections.reverse(Arrays.asList());

        return Math.max(leftLevel, rightLevel) + 1;
    }

    public boolean isBalance2(TreeNode root) {
        return Math.abs(height2(root.left) - height2(root.right)) <= 1 && isBalance2(root.left) && isBalance2(root.right);
    }

    private int height2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height2(node.left), height2(node.right)) +1;
    }
}
