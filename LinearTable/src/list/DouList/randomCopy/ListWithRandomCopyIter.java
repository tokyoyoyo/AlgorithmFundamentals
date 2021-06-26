package list.DouList.randomCopy;

import java.util.HashMap;
import java.util.Map;

public class ListWithRandomCopyIter {

    //迭代  以链表的视角进行处理
    Map<Node,Node> visited = new HashMap<>();

    public Node copyRandomList(Node head) {
        if(head == null){       //如果传入的是空表，直接返回空
            return null;
        }

        Node old = head; //
        Node newone = new Node(head.val,null,null);

        this.visited.put(old,newone);

        while(old != null){             //与递归版相比,差别只是用迭代
            newone.next = getClonedNode(old.next);
            newone.random = getClonedNode(old.random);


            old = old.next;
            newone = newone.next;
        }
        return this.visited.get(head);
    }

    public Node getClonedNode(Node node) {      //该方法的作用是获取迭代到的节点的副本

        if( node == null ){                     //若是空节点，直接返回空节点
            return null;
        }

        if(this.visited.containsKey(node)){       //如果已经复制过，直接返回map中存储的
            return this.visited.get(node);
        }else {                                 //如果既不是空节点，也没复制过，就创建副本，并且返回副本
            this.visited.put(node,new Node(node.val,null,null));
            return this.visited.get(node);
        }
    }
}
