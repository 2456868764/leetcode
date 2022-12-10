package com.jun.study.leetcode.recursion;

import com.jun.study.leetcode.tree.TreeNode;

import java.util.*;

/**
 *  https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        return  String.valueOf(root.val) + "," + serialize(root.left)  + "," + serialize(root.right);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> list = new ArrayDeque<>(Arrays.asList(data.split(",")));
        TreeNode root = deserializeTreeNode(list);
        return root;
    }

    private TreeNode deserializeTreeNode(Queue<String> data) {
        String value = data.poll();
        if ("null".equals(value)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(value));
        root.left = deserializeTreeNode(data);
        root.right = deserializeTreeNode(data);
        return root;

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

        Codec codec = new Codec();
        String serializeString = codec.serialize(node5);
        System.out.println("serialize:" + serializeString);
        String string = "5,1,null,null,7,6,null,null,8,null,null";
        TreeNode root = codec.deserialize(string);
        System.out.println("serialize:" + codec.serialize(root));

    }
}
