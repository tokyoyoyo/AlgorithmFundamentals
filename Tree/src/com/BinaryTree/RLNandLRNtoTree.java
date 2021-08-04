package com.BinaryTree;

import com.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: AlgorithmFundamentals
 * @className: RLNandLRNtoTree
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/8/4 13:55
 * @version: 1.0
 */

public class RLNandLRNtoTree {

    Map<Integer,Integer> inorderMap = new HashMap<Integer,Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0;i<inorder.length; i++){
            inorderMap.put(inorder[i],i);
        }

        return helper(0,inorder.length-1,preorder,0,preorder.length-1);
    }

    public TreeNode helper(int inLeft, int inRight, int[] preorder, int pLeft, int pRight){
        if(inRight<inLeft || pRight<pLeft){
            return null;
        }

        TreeNode root = new TreeNode(preorder[pLeft]);

        int indexRoot = inorderMap.get(preorder[pLeft]);

        root.left = helper(inLeft,indexRoot-1,preorder,pLeft + 1,pLeft + indexRoot-inLeft);
        root.right = helper(indexRoot + 1, inRight,preorder,pLeft + indexRoot-inLeft + 1, pRight);

        return root;
    }
}
