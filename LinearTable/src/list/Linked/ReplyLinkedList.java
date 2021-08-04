package list.Linked;



public class ReplyLinkedList {
    public boolean isPalindrome(ListNode head) {

        if( head == null || head.next == null ) //如果表为空，或表中只有一个元素，直接返回原表
            return true;

        ListNode halfHead = head;       //遍历前半表的工作指针
        ListNode half = getHalf(head);  //找到中间节点
        half = reverseList(half.next);  //逆置后半部分链表
        ListNode tag = half;            //记录中间节点

        while ( half !=null){
            if(half.val != halfHead.val){   //如果有不同的，说明不是回文链表，修复链表，返回false

                reverseList(tag.next);
                return false;
            }else {
                half = half.next;
                halfHead = halfHead.next;
            }
        }

        reverseList(tag.next);      //比对完了，说明是回文链表，修复链表，返回true
        return true;
    }

    private ListNode getHalf(ListNode head){    // 寻找中间节点   时间复杂度 O（n）
        ListNode faster = head;
        ListNode slower = head;

        while ( faster.next != null && faster.next.next != null){
            slower = slower.next;
            faster = faster.next.next;
        }

        return slower;

    }


    private ListNode reverseList(ListNode head) {   //逆置链表  时间复杂度O（n）

        if( head == null || head.next == null ) //如果表为空，或表中只有一个元素，直接返回原表
            return head;

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
    }
}



/*
        请判断一个链表是否为回文链表。

            示例 1:

            输入: 1->2
            输出: false
            示例 2:

            输入: 1->2->2->1
            输出: true
            进阶：
            你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？


        - 找到链表中间节点，快指针法
        - 将后半部分链表逆转
        - 比较前半部分链表和后半部分链表
        - 再次逆置后半部分链表，修复链表,逆置链表直接用的以前写过的代码
        - 时间复杂度：逆置两次后半部分的表(n)，寻找中间节点需要遍历整个表一次，比对节点 也需要遍历表（n / 2）。

*/