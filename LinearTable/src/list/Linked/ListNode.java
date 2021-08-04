package list.Linked;

/**
 * @projectName: AlgorithmFundamentals
 * @className: ListNode
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/8/3 19:09
 * @version: 1.0
 */

public class ListNode {		//定义节点类
    int val;
    ListNode next;


    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode() {		//三个构造方法
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}