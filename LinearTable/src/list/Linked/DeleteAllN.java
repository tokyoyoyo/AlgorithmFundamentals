package list.Linked;

public class DeleteAllN {

        public ListNode removeElements(ListNode head, int val) {

            ListNode dummyHead = new ListNode(0,head);  //创建一个头节点，方便处理

            ListNode workerPointer = dummyHead;             //工作指针指向头节点，此时工作指针指向第一个元素的前驱，因此可以方便的摘掉第一个元素

            while (workerPointer.next != null){             //通过工作指针处理的其实是工作指针的后继，所以循环条件为工作指针的后继不为空

                if(workerPointer.next.val == val){          //如果后继应该被删掉，就直接删
                    workerPointer.next = workerPointer.next.next;
                }else {                                     //如果不该删，就后移，处理下一位
                    workerPointer = workerPointer.next;
                }
            }

            return dummyHead.next;                          //整个链表都处理完后返回除去头结点的链表
        }
}


/**
 *
 *      通过引入头节点简化了操作
 *      在单链表中要插入或删除时，顺利执行操作的前提是获取待插入位置的前驱
 *
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */