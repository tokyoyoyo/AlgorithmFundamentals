package list.Linked;

import list.DouList.Dou.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {   //原题不允许用get,set方法
        int carry = 0;  //保存进位,初始值为零

        ListNode head = new ListNode(0,null);       //初始化，实际上是构造了一个带尾节点的带头结点的单链表
        ListNode tail = head;

        ListNode pointerL1 = l1;
        ListNode pointerL2 = l2;            //两个工作指针

        while (pointerL1 != null || pointerL2 != null){


            int n1 = (pointerL1==null ? 0 : pointerL1.getVal());        //取出待处理的值 ，使用三元运算符
            int n2 = (pointerL2==null ? 0 : pointerL2.getVal());

            carry = n1 + n2 + carry;                                    //将加和结果放入carry

            tail.setNext(new ListNode(carry % 10));                 //创建当前位节点存储当前位的值，尾插法
            tail = tail.getNext();

            if(pointerL1 != null){                                      //两个工作指针能后移的后移
                pointerL1 = pointerL1.getNext();
            }
            if(pointerL2 != null){
                pointerL2 = pointerL2.getNext();
            }


            carry /= 10;                                                //计算进位，carry只有0和1两个取值
        }

        if(carry>0){
            tail.setNext(new ListNode(carry));
            tail = tail.getNext();
            tail.setNext(null);             //封尾

        }

        return head.getNext();
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 *
 *
 *
 * 不带get、set的版本
 *
 * public ListNode addTwoNumbers(ListNode l1, ListNode l2) {  //不允许用get,set方法
 *         int carry = 0;  //保存进位,初始值为零
 *
 *         ListNode head = new ListNode(0,null);       //初始化，实际上是构造了一个带尾节点的带头结点的单链表
 *         ListNode tail = head;
 *
 *         ListNode pointerL1 = l1;
 *         ListNode pointerL2 = l2;            //两个工作指针
 *
 *         while (pointerL1 != null || pointerL2 != null){
 *
 *
 *             int n1 = (pointerL1==null ? 0 : pointerL1.val);        //取出待处理的值 ，使用三元运算符
 *             int n2 = (pointerL2==null ? 0 : pointerL2.val);
 *
 *             carry = n1 + n2 + carry;                                    //将加和结果放入carry
 *
 *             tail.next = new ListNode(carry % 10);                 //创建当前位节点存储当前位的值，尾插法
 *             tail = tail.next;
 *
 *             if(pointerL1 != null){                                      //两个工作指针能后移的后移
 *                 pointerL1 = pointerL1.next;
 *             }
 *             if(pointerL2 != null){
 *                 pointerL2 = pointerL2.next;
 *             }
 *
 *
 *             carry /= 10;                                                //计算进位，carry只有0和1两个取值
 *         }
 *
 *         if(carry>0){
 *             tail.next = new ListNode(carry);
 *             tail = tail.next;
 *             tail.next = null;             //封尾
 *
 *         }
 *
 *         return head.next;
 *     }
 * }
 *
 *
 * 
 */
