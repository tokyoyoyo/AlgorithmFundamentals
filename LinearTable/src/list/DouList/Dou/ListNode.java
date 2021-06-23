package list.DouList.Dou;

public class ListNode {

    private int val;
    private ListNode next;
    private ListNode front;

    public ListNode() {
    }

    public ListNode(int val, ListNode next, ListNode front) {
        this.val = val;
        this.next = next;
        this.front = front;
    }

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

    public ListNode getFront() {
        return front;
    }

    public void setFront(ListNode front) {
        this.front = front;
    }
}
