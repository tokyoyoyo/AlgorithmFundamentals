package list.Linked;

public class IntersectingLinkedList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA;
        ListNode pb = headB;

//        解法一
//        分别遍历两个链表，得到各自长度
//        长表指针先走，等到两表剩余节点数一致时两表指针一起后移
//        两边指针一起后移时比较引用指向的是否为同一个节点，若是则找到了交叉节点返回该节点
//        如果不相交，两引用会同时指向空，则会返回空，表示不相交
//        复杂度为O（2（m+n）） m为表A长度，n为表B长度

        int a = 0;
        int b = 0;

        while (pa.next != null){
            pa = pa.next;
            a++;
        }

        while (pb.next != null){
            pb = pb.next;
            b++;
        }
        pa = headA;
        pb = headB;

        int num = a > b?  a-b : b-a ;

        if(a>b){
            for (int i = 0; i < num; i++) {
                pa = pa.next;
            }
        }else {
            for (int i = 0; i < num; i++) {
                pb = pb.next;
            }
        }

        while (pa != pb){
            pa = pa.next;
            pb = pb.next;
        }

        return pa;
    }

}


//解法二
//        走到尽头见不到你，于是走过你来时的路，等到相遇时才发现，你也走过我来时的路。
//
//        双指针法
//        两个指针交替的遍历表A和表B，目的也是消除两表长度差
//        优点是代码简洁，缺点是不便理解
//        复杂度也为O（2（m+n）） m为表A长度，n为表B长度

//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//
//        ListNode pa=headA;		//工作引用
//        ListNode pb=headB;
//
//        while(pa!=pb)
//        {
//            pa = pa ? pa.next:headB;	//pa没有走到表尾就继续向走，走到了表尾就转到表B遍历表B，
//            pb = pb ? pb.next:headA;
//        }
//        return pa;
//    }
