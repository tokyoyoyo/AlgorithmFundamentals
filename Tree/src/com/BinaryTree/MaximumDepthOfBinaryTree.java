package com.BinaryTree;

import com.TreeNode;

/**
 * @projectName: AlgorithmFundamentals
 * @className: MaximumDepthOfBinaryTree
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/8/3 1:46
 * @version: 1.0
 */

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}
