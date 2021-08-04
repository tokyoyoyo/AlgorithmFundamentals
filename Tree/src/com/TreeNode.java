package com;

/**
 * @projectName: AlgorithmFundamentals
 * @className: TreeNode
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/7/31 12:43
 * @version: 1.0
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}