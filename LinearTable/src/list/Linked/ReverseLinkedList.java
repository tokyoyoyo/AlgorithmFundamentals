package list.Linked;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {

        if( head == null || head.next == null ) //如果表为空，或表中只有一个元素，直接返回原表
            return head;

        //   递归解法

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;

//        迭代解法
        /*

        ListNode workPointer = head.next;       //workPoint是工作指针，tag用来保存链表还没处理的部分
        head.next = null;                       //将第一个元素摘下，看作一个只有一个元素的链表
        ListNode tag;
        while (workPointer != null){            //workPoint与tag协作，将链表中还未处理完的部分一个一个的头插到head，并将head指针指向刚插入的元素
                                                //指针，指引用
            tag = workPointer.next;
            workPointer.next = head;
            head= workPointer;
            workPointer = tag;
        }

        return head;

         */
    }
}


/*
 * https://leetcode-cn.com/leetbook/read/linked-list/f58sg/
 *
 *
        假设链表为：
        1 -> 2 -> 3 -> 4 -> 5 - > null

        假设3到5已经被反转
        1 -> 2 -> 3 <- 4 <- 5  (3指向null)

        我们希望3指向2，
        所以需要 让3.next = 2;
        而 3 == 2.next
        即2.next.next = 2;
        链表变成
        1 -> 2 <-> 3 <- 4 <- 5  (2 与 3 互相指向)

        只需要让2指向null
        链表变为
        1 -> 2 <- 3 <- 4 <- 5  (2指向null)
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