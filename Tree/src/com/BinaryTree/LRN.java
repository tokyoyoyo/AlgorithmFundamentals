package com.BinaryTree;

import com.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @projectName: AlgorithmFundamentals
 * @className: LRN
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/8/1 21:50
 * @version: 1.0
 */

public class LRN {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> order = new ArrayList<>();

        if (root == null) {
            return order;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode node = root;
        TreeNode pre = null;

        while (!stack.isEmpty() || node != null){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if(node.right == null || node.right == pre){
                order.add(node.val);
                pre = node;
                node = null;    //node置为null以防他的左节点重复入栈
            }else {
                stack.push(node);
                node = node.right;
            }
        }
        return order;
    }
}
