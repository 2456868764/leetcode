package com.jun.study.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-inorder-traversal
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        inorderTree(root, res);
        return res;
    }

    public void inorderTree(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorderTree(root.left, res);
        res.add(root.val);
        inorderTree(root.right, res);
    }

    public void inorderTree0928(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorderTree0928(root.left, res);
        res.add(root.val);
        inorderTree0928(root.right, res);
    }


    public static void main(String[] args) {

    }
}
