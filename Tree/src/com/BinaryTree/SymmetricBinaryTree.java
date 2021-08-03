package com.BinaryTree;

import com.TreeNode;

/**
 * @projectName: AlgorithmFundamentals
 * @className: SymmetricBinaryTree
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/8/3 14:13
 * @version: 1.0
 */

public class SymmetricBinaryTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isMirror(root,root);
    }

    public boolean isMirror(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }else if(left == null || right == null || left.val != right.val){
            return false;
        }
        return isMirror(left.left,right.right) && isMirror(left.right, right.left);
    }

}
