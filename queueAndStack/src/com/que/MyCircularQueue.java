package com.que;

//空位法
public class MyCircularQueue {
    private  int[] arrary;
    private int head;
    private int tail;

    public MyCircularQueue(int k) {
        arrary = new int[k+1];
        head = 0;
        tail = 0;
    }

    public boolean enQueue(int value) {
        if(isFull())
            return false;
        arrary[tail++] = value;
        tail %= arrary.length;

        return true;
    }

    public boolean deQueue() {
        if(isEmpty())
            return false;
        head = (head+1)%arrary.length;
        return true;
    }

    public int Front() {
        if(isEmpty())
            return -1;
        return arrary[head];
    }

    public int Rear() {
        if(isEmpty())
            return -1;
        return arrary[(tail+arrary.length-1)%arrary.length];
    }

    public boolean isEmpty() {
        return head == tail ;
    }

    public boolean isFull() {
        return  (tail+1)%arrary.length == head;
    }
}



/*
        设计循环队列

标签法：
class MyCircularQueue {

    private  int[] arrary;
    private  boolean tag=false;
    private int head;
    private int tail;

    public MyCircularQueue(int k) {
        arrary = new int[k];
        head = 0;
        tail = 0;
    }

    public boolean enQueue(int value) {
        if(isFull())
            return false;
        arrary[tail++] = value;
        tail %= arrary.length;

        tag = true;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty())
            return false;
        head++;
        head %= arrary.length;
        tag = false;
        return true;
    }

    public int Front() {
        if(isEmpty())
            return -1;
        return arrary[head];
    }

    public int Rear() {
        if(isEmpty())
            return -1;
        return arrary[(tail+arrary.length-1)%arrary.length];
    }

    public boolean isEmpty() {
        return head == tail && tag== false;
    }

    public boolean isFull() {
        return  head == tail && tag == true;
    }
}

https://leetcode-cn.com/leetbook/read/queue-stack/kzlb5/

 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */