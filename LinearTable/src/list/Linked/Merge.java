package list.Linked;

import  list.DouList.Dou.ListNode;

public class Merge {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        //传入的是无头结点的有序单链表
        if( l1 == null ){
            return l2;
        }else if(l2 == null){
            return l1;
        }

        ListNode ans = new ListNode();  //头指针
        ListNode rear = ans;        //尾指针

        while( l1!=null && l2!=null){       //比较待处理节点的值，将较小的尾插到结果链

            if(l1.getVal() < l2.getVal()){
                rear.setNext(l1);
                l1 = l1.getNext();
            }else{
                rear.setNext(l2);
                l2 = l2.getNext();
            }
            rear = rear.getNext();
        }

        if(l1 ==null){      //其中一条链处理完成后，将另一条接上去
            l1 = l2;
        }
        rear.setNext(l1);

        return ans.getNext();

    }

}



/*

https://leetcode-cn.com/leetbook/read/linked-list/fnzd1/



 */