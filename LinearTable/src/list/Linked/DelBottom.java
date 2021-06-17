package list.Linked;
//删除链表的倒数第N个节点

//链表中结点的数目为 sz
//        1 <= sz <= 30
//        0 <= Node.val <= 100
//        1 <= n <= sz

public class DelBottom {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //该题目采用的是无头结点的单链表，为了方便先加一个假头节点

        ListNode dummyHead = new ListNode(0,head);

        ListNode front = head;  //front指向第一个元素
        ListNode behind = dummyHead;    //behind指向假头节点

        for (int i = 0; i < n; ++i ) {       //front移动后指向的其实是第n+1个元素，front与behind之间隔着n个节点
            front = front.next;
        }

//        1 <= n <= sz

        while ( front != null ){            //情况一：n = 链表长度。此时删除第一个节点（head），而behind还指向dummyHead，删掉后返回dummyHead.next即可
            front = front.next;
            behind = behind.next;           //情况二 n < 链表长度，两个指针一起后移，front指向表尾的null时，behind刚好指向倒数第n个节点的前驱，因为front与behind之间隔着n个节点
        }
        behind.next = behind.next.next;     //两种情况都只需要删掉behind的后继并返回dummyHead.next

        front =dummyHead.next;

        return front;
    }
}


/*
 *
 * https://leetcode-cn.com/leetbook/read/linked-list/jf1cc/
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 * 删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 *
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 *
 * 提示：
 *
 * **链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz**
 *
 * 注意题目给的提示，不需要考虑n大于sz的情况
 *
 * - 本题使用的数据结构是无头结点的单链表，为了方便操作，加一个头节点
 * - 双指针法，利用两个指针之间固定的间隔来寻找应该被删除的节点的前驱
 */