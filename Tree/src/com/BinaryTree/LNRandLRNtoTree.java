package com.BinaryTree;

import com.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: AlgorithmFundamentals
 * @className: LNRandLRNtoTree
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/8/4 12:38
 * @version: 1.0
 */

public class LNRandLRNtoTree {

    Map<Integer,Integer> inorderMap = new HashMap<Integer,Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for (int i = 0;i<inorder.length; i++){
            inorderMap.put(inorder[i],i);
        }

        return helper(0,inorder.length-1,postorder,0,postorder.length-1);
    }

    public TreeNode helper(int inLeft, int inRight, int[] postorder, int pLeft, int pRight){
        if(inRight<inLeft || pRight<pLeft){
            return null;
        }

        TreeNode root = new TreeNode(postorder[pRight]);

        int indexRoot = inorderMap.get(postorder[pRight]);

        root.left = helper(inLeft,indexRoot-1,postorder,pLeft,pLeft + indexRoot-inLeft-1);
        root.right = helper(indexRoot + 1, inRight,postorder,pLeft + indexRoot-inLeft, pRight-1);

        return root;
    }
}
