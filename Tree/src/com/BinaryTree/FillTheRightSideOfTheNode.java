package com.BinaryTree;

/**
 * @projectName: AlgorithmFundamentals
 * @className: FillTheRightSideOfTheNode
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/8/6 0:13
 * @version: 1.0
 */

public class FillTheRightSideOfTheNode {
    public Node connect(Node root) {
        if(root != null){
            helper(root.left, root.right);
        }
        return root;
    }

    void helper(Node left, Node right){
        if(left == null || left.next == right){
            return;
        }
        left.next = right;

        helper(left.left, left.right);
        helper(left.right, right.left);
        helper(right.left, right.right);
    }
}
