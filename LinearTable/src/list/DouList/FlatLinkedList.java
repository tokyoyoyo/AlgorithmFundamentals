package list.DouList;

//扁平化多级双向链表：https://leetcode-cn.com/leetbook/read/linked-list/fw8v5/
// 递归版
public class FlatLinkedList {
    public Node flatten(Node head) {
        if(head == null ) {
            return head;        //如果传入的是空表，不需要处理，直接返回
        }

        Node dummyHead = new Node(0,null,head,null);        //创建一个头结点，简化操作

        flattenDFS(dummyHead,head);         //递归的处理每个节点,第二个参数才是被处理的节点，第一个参数只是提供一个前驱供待处理节点连接

        dummyHead.next.prev = null;
        return dummyHead.next;

    }

    public Node flattenDFS(Node pre,Node cur){      //以cur作为当前处理的焦点

        if(cur == null){        //如果当前节点是null，什么也不做,把叶子节点返回，           递归出口
            return pre;
        }

        cur.prev = pre;         //步骤一：如果当前节点不是null，将当前节点与父节点连接          处理根节点
        pre.next = cur;

        Node temp = cur.next;           //temp暂存右子树

        Node tail = flattenDFS(cur, cur.child);     //步骤二：递归的处理左子树                 处理左子树

        cur.child = null;               //左子树处理完毕，不需要再保留child指针

        return flattenDFS(tail,temp);       //步骤三：  处理右子树， 并将处理结果连接在处理后的左子树上
    }
}
