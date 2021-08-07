package com.BinaryTree;

/**
 * @projectName: AlgorithmFundamentals
 * @className: Node
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/8/6 0:14
 * @version: 1.0
 */

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}