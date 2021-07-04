package com.stack;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode-cn.com/leetbook/read/queue-stack/g9d0h/

public class ValidParenthesis {
    public boolean isValid(String s) {

        char[] str = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < str.length; i++) {
            //如果是左括号，就把他们对应的右括号压栈
            if (str[i] == '(') {
                stack.push(')');
            } else if (str[i] == '{') {
                stack.push('}');
            } else if (str[i] == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != str[i]) {
                //否则就只能是右括号。
                //1，如果栈为空，说明括号无法匹配。
                //2，如果栈不为空，栈顶元素就要出栈，和这个右括号比较。
                //如果栈顶元素不等于这个右括号，说明无法匹配，
                //直接返回false。
                return false;
            }

        }
        return stack.isEmpty();
    }
}
