package com.BinaryTree;


import com.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @projectName: AlgorithmFundamentals
 * @className: NLR
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/8/1 16:45
 * @version: 1.0
 */

public class NLR {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> order = new ArrayList<>();
        if(root == null){
            return order;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        
        while (!stack.isEmpty() || node != null){
            while (node != null){
                order.add(node.val);
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            node = node.right;
        }
        return order;
    }
}
