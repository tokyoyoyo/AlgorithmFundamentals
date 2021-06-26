package list.DouList.randomCopy;

import java.util.HashMap;
import java.util.Map;


public class ListWithRandomCopy {


    //  本质上是递归，并且用hashMap保存信息         以图的视角进行处理，所以采用递归
    Map<Node,Node> visited =new HashMap<>();    //通过HashMap将新旧节点一一对应的保存，并且以旧节点为key方便找到新结点

    public Node copyRandomList(Node head) {

        if(head == null){       //一个边界条件，如果传入的是空表，那么不需要处理
            return null;
        }

        if(this.visited.containsKey(head)){
            return this.visited.get(head);     //如果map中有该节点的head节点key，说明这个节点已经处理过了，直接返回即可
        }

        //未处理过的情况
        Node node = new Node(head.val,null,null); //复制旧节点


        this.visited.put(head,node);    //将新旧节点对放入map中，说明已经处理过这个节点了

        node.next = this.copyRandomList(head.next);         //递归的处理next节点和random节点
        node.random = this.copyRandomList(head.random);

        return node;    //递归复制整个表后，node节点就是头节点，直接返回就好
    }
}
