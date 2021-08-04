package list.Linked;

public class MyLinkedList {

    private ListNode head;
    private ListNode tail;
    /** Initialize your data structure here. */
    public MyLinkedList() {		//new一个节点，并让头引用尾引用都指向它
        head = new ListNode();	//new一个节点，并让头引用指向它
        tail = head;				//头引用赋值给尾引用
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
        head.setNext(new ListNode(val,head.getNext()));	//初始化一个节点，赋值，
        //并让该节点引用指向第一个元素
        //然后让head引用指向该节点
        head.setVal(head.getVal()+1);			//元素总数+1

        if(tail.getNext() != null ){		   //维护尾引用的指向
            tail = tail.getNext();			   //尾引用后移
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        tail.setNext(new ListNode(val));			//初始化节点并赋值，尾引用指向节点
        tail = tail.getNext();						//尾引用后移

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
            pointer.setNext(new ListNode(val,pointer.getNext()));
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
            pointer.setNext( pointer.getNext().getNext());
            if(pointer.getNext() == null ){
                tail = pointer;
            }
            head.setVal(head.getVal() - 1 );		//元素总数-1
        }
    }
}



/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 *
 *  https://leetcode-cn.com/leetbook/read/linked-list/jy291/
 *
 * 您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 *
 * 在链表类中实现这些功能：
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 *
 * 示例：
 *
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 *
 *
 * 提示：
 *
 * 所有val值都在 [1, 1000] 之内。
 * 操作次数将在  [1, 1000] 之内。
 * 请不要使用内置的 LinkedList 库。
 *
 * 很简单，只是有几个细节
 *
 * - 使用单链表完成要求
 * - 通过尾指针快速读取尾节点
 * - 引入一个头节点，将空表与非空表的操作统一，将插入到0号位置与其他位置的操作统一。并且头节点中的val变量可以存储表中元素个数。
 * - index为元素的索引下标，取值范围 [ 0  ， head.getval() - 1 ]
 */