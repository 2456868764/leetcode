package com.jun.study.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.cn/problems/n-ary-tree-level-order-traversal
 */
public class NaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int cnt = deque.size();
            List<Integer> items = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                TreeNode node = deque.poll();
                items.add(node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }

            }
            result.add(items);
        }
        return result;
    }

    public List<List<Integer>> levelOrder0928(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int cnt = deque.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                TreeNode node = deque.poll();
                level.add(node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }


}
