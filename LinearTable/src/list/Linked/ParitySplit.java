package list.Linked;

public class ParitySplit {

//      将原表先拆成两个表，然后拼接并返回
//      操作繁琐，因为既要判断又要修改

    public ListNode oddEvenList01(ListNode head) {
        //如果链表小于3个那么直接返回
        if(head==null||head.next==null||head.next.next==null){
            return head;
        }

        ListNode oddHead = new ListNode(0,null);    //奇头节点
        ListNode evenHead = new ListNode(0,null);   //偶头节点

        ListNode oddTail = oddHead;       //因为顺序不变，采用尾插法，建立两个尾指针
        ListNode evenTail = evenHead;

        ListNode worker = head;

        Boolean Odd = true;

        while (worker != null){             //将原表按奇偶分为两个表
            if(Odd){    //如果当前处理的节点是奇节点
                oddTail.next = worker;
                oddTail = oddTail.next;
                Odd = false;        //重置下一个节点的标记
            }else {
                evenTail.next = worker;
                evenTail = evenTail.next;
                Odd = true;
            }
            worker = worker.next;
        }

        oddTail.next = evenHead.next;   //将偶表拼接在奇表后

        evenTail.next = null;       //因为使用的是尾插法，所以需要封尾


        return oddHead.next;
    }

    public static ListNode oddEvenList02(ListNode head) {
        //如果链表小于3个那么直接返回
        if(head==null||head.next==null||head.next.next==null){
            return head;
        }
        //定义第一条指针
        ListNode secondhead=head;
        //定义第二条指针
        ListNode oneHead=head.next;
        //定义第一条指针的开始位置
        ListNode one=secondhead;
        //定义第二条指针开始的位置
        ListNode tow=oneHead;
        while(secondhead!=null&&secondhead.next!=null&&secondhead.next.next!=null){
            //然后这里就是相互的删除中间的元素，也就是逻辑删除
            secondhead.next=secondhead.next.next;
            secondhead=secondhead.next;
            oneHead.next=oneHead.next.next;
            oneHead=oneHead.next;
        }
        secondhead.next=tow;
        return one;

        /*
        作者：无名
        链接：https://leetcode-cn.com/leetbook/read/linked-list/fe0kj/?discussion=YtA4gA
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

        */
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
 * https://leetcode-cn.com/leetbook/read/linked-list/fe0kj/
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推
 */