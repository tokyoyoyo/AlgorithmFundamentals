package com.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @projectName: AlgorithmFundamentals
 * @className: MyStack
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/7/31 13:39
 * @version: 1.0
 */

public class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q2.offer(x);
        while (!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.poll();
    }

    /** Get the top element. */
    public int top() {
        return q1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
