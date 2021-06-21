package list.DouList.Dou;

/*
用循环双链表设计了一下

https://leetcode-cn.com/leetbook/read/linked-list/fabl3/

 */
public class MyLinkedList {

    public ListNode head;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new ListNode(0,null,null);
        head.setFront(head);
        head.setNext(head);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= head.getVal()){	//index范围不对，返回-1
            return  -1;
        }

        ListNode pointer = head;			//声明一个工作引用
        for (int i = 0 ; i < index + 1 ; ++i ){	//index这里加1了，因为index从零开始，而头引用指向头节点，当index=0，工作引用要后移一位指向index为0的第一个元素，需要后移一位，思路类似于数组下标，工作引用一开始指向-1。
            pointer = pointer.getNext();
        }
        return pointer.getVal();
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {

        head.setNext(new ListNode(val,head,head.getNext()));    //新建节点并指定它的前驱和后继    头节点的后继指向新节点
        head.getNext().getNext().setFront(head.getNext());      //      原本的第一个节点的前驱指向新节点

        head.setVal(head.getVal()+1);			//元素总数+1
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        head.setFront(new ListNode(val, head.getFront(),head));     //新建节点并指定它的前驱和后继    头节点的前驱指向新节点
        head.getFront().getFront().setNext(head.getFront());        //      原本的最后一个节点的后继指向新节点

        head.setVal(head.getVal()+1);			//元素总数+1

    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index <= 0 ){					//index <= 0 时都是头插，直接调用实现了的头插
            addAtHead(val);
        }else if(index == head.getVal()){		//index == 元素总数时是尾插，直接调用实现了的尾插
            addAtTail(val);
        }else if(index > head.getVal()){
            //index  > 元素总数，什么也不做
        }else {										//index 在[ 1 , head.getval() - 1 ]时，找到对应的前驱并插入即可
            ListNode pointer = head;				//新建工作引用并指向头节点
            for(int i = 0 ; i < index ; ++i){		//相比get方法，工作引用不需要访问到被插入节点，只需要访问被插入结点的前驱，所以不需要加1
                pointer = pointer.getNext();
            }
            pointer.setNext(new ListNode(val, pointer , pointer.getNext()));
            pointer.getNext().getNext().setFront(pointer.getNext());

            head.setVal(head.getVal() + 1 );		//元素总数+1
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= 0 && index < head.getVal() ){
            ListNode pointer = head;
            for (int i = 0 ; i < index ; ++i){			//与插入类似，工作引用只需要访问到被删除节点的前驱，所以index不需要+1
                pointer = pointer.getNext();
            }
            pointer.setNext( pointer.getNext().getNext());      //pointer指向待删除结点的后继
            pointer.getNext().getFront().setNext(null);         //另待删除结点的前驱后继都指向null
            pointer.getNext().getFront().setFront(null);
            pointer.getNext().setFront(pointer);                //令pointer的后继指向pointer

            head.setVal(head.getVal() - 1 );		//元素总数-1
        }

    }
}

class ListNode {
    private int val;
    private ListNode next;
    private  ListNode front;

    public ListNode(int val, ListNode front, ListNode next ) {
        this.val = val;
        this.next = next;
        this.front = front;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getFront() {
        return front;
    }

    public void setFront(ListNode front) {
        this.front = front;
    }
}
