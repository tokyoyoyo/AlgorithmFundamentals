package com.BinaryTree;

/**
 * @projectName: AlgorithmFundamentals
 * @className: FillTheRightSideOfTheNodeTwo
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/8/7 22:50
 * @version: 1.0
 */

public class FillTheRightSideOfTheNodeTwo {
    public Node connect(Node root) {
        if(root != null){
            if(root.left != null){
                root.left.next = root.right != null ? root.right : getNext(root.next);
            }
            if(root.right != null){
                root.right.next = getNext(root.next);
            }
            connect(root.right);
            connect(root.left);
        }
        return root;
    }

    public Node getNext(Node rootNext){
        if(rootNext == null){
            return null;
        }else if(rootNext.left != null){
            return rootNext.left;
        }else if(rootNext.right != null){
            return rootNext.right;
        }else {
            return getNext(rootNext.next);
        }
    }
}
