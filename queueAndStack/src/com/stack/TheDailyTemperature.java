package com.stack;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode-cn.com/leetbook/read/queue-stack/genw3/

public class TheDailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]){   //要用while
                int pos = stack.pop();
                ans[pos] = i-pos;
            }

            stack.push(i);
        }
        return ans;
    }
}
