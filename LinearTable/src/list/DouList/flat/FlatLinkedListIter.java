package list.DouList.flat;

import list.DouList.flat.Node;

import java.util.ArrayDeque;
import java.util.Deque;

//扁平化多级双向链表：https://leetcode-cn.com/leetbook/read/linked-list/fw8v5/
// 迭代版
public class FlatLinkedListIter {

    public Node flatten(Node head) {
        if(head == null){
            return head;
        }

        Node dummyHead = new Node(0,null,head,null);        //创建一个头结点，简化操作
        Node pre = dummyHead;
        Node cur;

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(head);                   //将头节点入栈，使栈中至少有一个节点

        while (!stack.isEmpty()){           //当栈不为空时
            cur = stack.pop();
            pre.next = cur;                 //将当前处理的节点与其父节点连接。迭代法只处理当前节点，但是限制了子树的处理顺序
            cur.prev = pre;

            if (cur.next != null) stack.push(cur.next);       //如果当前节点有右子树，推入栈中

            if(cur.child != null){                          //如果当前节点有左子树，推入栈中
                stack.push(cur.child);
                cur.child = null;                       //顺便处理左子树引用
            }                                           //栈的先入后出保证了先处理左子树再处理右子树

            pre = cur;
        }

        dummyHead.next.prev = null;
        return dummyHead.next;

    }
}
