package com.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    Deque<Integer> stack;
    Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val) {     //如果推入栈的值等于栈中的最小值是特殊情况
        if(minStack.isEmpty()|| val <= minStack.peek()){
            minStack.push(val);
        }

        stack.push(val);

    }

    public void pop() {
        if(stack.pop() == getMin()){
            //此处要调用getMin得到一个int,如果直接用minStack.peek（）不能正常执行，
            // 因为peek返回的是泛型。不是int类型。所以不能用==比较
            minStack.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    @Override
    public String toString() {
        return "MinStack{" +
                "stack=" + stack +
                ", \nminStack=" + minStack +
                "}\n";
    }

}

/**
 *
 * https://leetcode-cn.com/leetbook/read/queue-stack/g5l7d/
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
