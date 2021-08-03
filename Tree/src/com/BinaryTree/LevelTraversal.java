package com.BinaryTree;

import com.TreeNode;

import java.util.*;

/**
 * @projectName: AlgorithmFundamentals
 * @className: LevelTraversal
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/8/1 22:24
 * @version: 1.0
 */

public class LevelTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> order = new ArrayList<>();
        if (root == null){
            return order;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode node = null;
        queue.offer(root);


        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size-- > 0){
                node = queue.poll();
                level.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            order.add(level);
        }
        return order;
    }
}
