package list.Linked;

public class CircularList01 {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public boolean hasCycle(ListNode head) {
        ListNode faster = head;
        ListNode slower = head;

        //空表 head指向null，直接返回false
        //只有一个元素且不成环， head.next 指向null 直接返回false
        //两个及以上的元素，且不成环  指针最终会走到表尾，跳出while   跳出循环后，返回null.

//        非以上三种情况的话，快慢指针一定会相遇，相遇时返回true

        while(faster != null && faster.next != null ){
            faster = faster.next.next;
            slower = slower.next;
            if(slower == faster){
                return true;
            }
        }
        return false;
    }
}

class ListNode{
    //压制报错用的
    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
/*

https://leetcode-cn.com/leetbook/read/linked-list/jbex5/

给定一个链表，判断链表中是否有环。

如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

如果链表中存在环，则返回 true 。 否则，返回 false 。



进阶：

你能用 O(1)（即，常量）内存解决此问题吗？



示例 1：



输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。




输入：head = [1,2], pos = 0
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。
示例 3：



输入：head = [1], pos = -1
输出：false
解释：链表中没有环。


提示：

链表中节点的数目范围是 [0, 104]
-105 <= Node.val <= 105
pos 为 -1 或者链表中的一个 有效索引 。

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/linked-list/jbex5/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

