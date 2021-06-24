package list.Linked;

import list.DouList.Dou.ListNode;

public class RotatingLinkedList {
    public ListNode rotateRight(ListNode head, int k) {     //传入的是无头结点的单链表

        ListNode front  = head;
        ListNode temp   = head;

        if (k == 0 || head == null || head.getNext() == null) {
            return head;
        }

        /*不需要改动的情况，直接返回
                k == 0 : 不需要移动
                head == null ： 是空表，不需要移动
                head.getNext() == null  ： 只有一个元素，怎么移动都一样，直接返回
         */

        int count =1;

        while(front.getNext() != null){      //计算链表节点个数
            front = front.getNext();
            count ++;
        }

        k %= count;             //通过取余，简化操作
        k = count-k;            //获取需要移动的节点数

        front.setNext(head);     //将链表首尾连接成环,因为上一步已经使得front指向了表尾，成了循环单链表

        while( k-- != 1 ){
            temp = temp.getNext();      //找到要断开环的地方
        }

        head = temp.getNext();               //头节点后移，拆环
        temp.setNext(null);                  //恢复成普通单链表

        return head;
    }
}


/*

        https://leetcode-cn.com/leetbook/read/linked-list/f00a2/

        
        首先明确该题目的链表是无头结点的单链表，因此旋转的操作可以通过先将链表改为循环单链表，然后在恰当的地方断开来完成要求

            第一步： 判断是否需要处理，不需要的直接原样返回

            第二步： 如果需要处理，那么遍历链表。 作用一、统计链表结点个数，方便下一步操作，作用二，找到表尾节点，方便成环

            第三步： 通过对K取余，将K>链表长度的情况转变为K<链表长度的情况，这样就只需要考虑k<链表长度的情况了

            第四步： 链表长度-k。得到的就是新的头节点应在的位置

            第五步： 选定新的头节点，并且断开环

            本质上就是先找到倒数第k+1个节点，把链表从这里断开，然后将原来的尾节点链接到之前的头节点，并指定新的头节点，只不过通过先成环再断开的方式实现



 */