package list.DouList.randomCopy;

public class ListWithRandomCopyIter02 {

    //以链表视角进行迭代，将新节点依附在老节点后，完成HashMap的功能
    public Node copyRandomList(Node head) {
        if(head == null){               //如果传入的是空表，直接返回空
            return null;
        }

        Node tmp = head;

        while (tmp != null){
            tmp.next = new Node(tmp.val, tmp.next,null);
            tmp = tmp.next.next;
            //将表A->B->C转换为A->A'->B->B'->C->C'
        }

        tmp = head;
        while (tmp != null){        //复制random指针
            tmp.next.random = tmp.random != null ? tmp.random.next : null;
            tmp = tmp.next.next;
        }

        Node oldList = head;            //两个工作指针，和一个标记新表头结点的指针
        Node newList = head.next;
        Node ans = head.next;

        while (oldList != null){    //拆表,
            oldList.next = oldList.next.next;
            newList.next = newList.next != null ? newList.next.next : null;

            oldList = oldList.next;
            newList = newList.next;
        }

        return ans;
    }
}
