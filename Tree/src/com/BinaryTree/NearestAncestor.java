package com.BinaryTree;

import com.TreeNode;

public class NearestAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( root == p || root == q || root == null){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left == null && right == null){
            return null;
        }
        if (left != null && right != null){
            return root;
        }

        return left == null? right : left;
    }
}

/*
*       https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xopaih/
* */