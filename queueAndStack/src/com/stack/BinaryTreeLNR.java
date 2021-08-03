package com.stack;

import com.nodes.TreeNode;
import com.sun.deploy.panel.ITreeNode;

import java.util.*;

/**
 * @projectName: AlgorithmFundamentals
 * @className: BinaryTreeLNR
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/7/31 12:38
 * @version: 1.0
 */

public class BinaryTreeLNR {
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> order = new ArrayList<>();

        TreeNode carry = root;

        while (carry != null || !stack.isEmpty()){
            while (carry != null){
                stack.push(carry);
                carry = carry.left;
            }

            carry = stack.pop();
            order.add(carry.val);
            carry = carry.right;
        }

        return order;
    }
}
