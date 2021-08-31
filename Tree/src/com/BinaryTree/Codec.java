package com.BinaryTree;

import com.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "#";
        }
        StringBuilder stringBuilder = new StringBuilder();
        encodeHelper(root,stringBuilder);
        return stringBuilder.toString();
    }

    public void encodeHelper(TreeNode root, StringBuilder builder){
        if (root == null){
            builder.append('#').append(',');
            return ;
        }
        builder.append(String.valueOf(root.val)).append(',');
        encodeHelper(root.left,builder);
        encodeHelper(root.right,builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> queue = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return helper(queue);
    }

    public TreeNode helper(Deque<String> queue){
        String val = queue.poll();
        if ("#".equals(val)){
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = helper(queue);
        node.right = helper(queue);

        return node;
    }
}
