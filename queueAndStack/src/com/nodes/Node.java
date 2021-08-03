package com.nodes;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: AlgorithmFundamentals
 * @className: Node
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/7/31 12:42
 * @version: 1.0
 */

public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}