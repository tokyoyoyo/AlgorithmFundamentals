package com.BinaryTree;

import com.TreeNode;

/**
 * @projectName: AlgorithmFundamentals
 * @className: ThroughCombined
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/8/4 11:23
 * @version: 1.0
 */

public class ThroughCombined {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return root.val == targetSum;
        }
        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum - root.val);
    }
}
