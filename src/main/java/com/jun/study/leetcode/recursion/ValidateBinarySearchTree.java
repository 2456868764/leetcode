package com.jun.study.leetcode.recursion;

import com.jun.study.leetcode.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    public boolean isValidBSTRecursion(TreeNode root, int minValue, int maxValue) {
        //terminator
        if (root == null) {
            return true;
        }
        if (root.val < minValue || root.val > maxValue) {
            return false;
        }

        return isValidBSTRecursion(root.left, minValue, root.val) && isValidBSTRecursion(root.right, root.val, maxValue);

    }

    public boolean isValidBST(TreeNode root) {
        return isValidBSTRecursion(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }




    long pre = Long.MIN_VALUE;
    public boolean isValidBSTInorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
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
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
//        boolean isValid = validateBinarySearchTree.isValidBST2(node5);
        boolean isValid = validateBinarySearchTree.isValidBST(node5);
        System.out.println("isValid: " + isValid);
    }
}
