package com.stack;

import com.nodes.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @projectName: AlgorithmFundamentals
 * @className: CloneFig
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/7/26 16:14
 * @version: 1.0
 */

public class CloneFig {

    private HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {

        if(node == null){
            return null;
        }else if(visited.containsKey(node)){
            return visited.get(node);   //值和下标相同，返回值就相当于返回了索引
        }else {
            Node cloneNode = new Node(node.val);
            visited.put(node,cloneNode);
            for ( Node neighbor : node.neighbors){
                cloneNode.neighbors.add(cloneGraph(neighbor));
            }
            return cloneNode;
        }
    }
}


