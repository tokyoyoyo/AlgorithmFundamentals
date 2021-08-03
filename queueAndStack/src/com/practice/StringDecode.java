package com.practice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @projectName: AlgorithmFundamentals
 * @className: StringDecode
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/7/31 16:09
 * @version: 1.0
 */

public class StringDecode {

    public String decodeString(String s) {
        Deque<Integer> dataStack = new ArrayDeque<>();
        Deque<Character> charStack = new ArrayDeque<>();
        List<Character> tempList = new LinkedList();

        StringBuilder dataChars = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);

            if (Character.isDigit(character)){
                dataChars.append(character);
                // 获取一个数字并以字符的形式存储
            } else if("[".equals(character.toString())) {
                dataStack.push(Integer.parseInt(dataChars.toString()));
                //遇到[就将字符形式存储的数字转换为整数形式进入数字栈
                dataChars.delete(0, dataChars.length());
                charStack.push(character);
            }else if(!"]".equals(character.toString())){
                charStack.push(character);
                //如果不是]就入栈
            }else {
                //如果遇到右括号，应当将字符栈内左括号前的字符统统弹出，然后根据数字栈重复输入字符栈
                while (!"[".equals(charStack.peek().toString())){
                    tempList.add(0, charStack.pop());
                }
                charStack.pop();

                int times = dataStack.pop();
                while (times-- > 0){
                    for( Character c :tempList){
                        charStack.push(c);
                    }
                }
                tempList.clear();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!charStack.isEmpty()){
            stringBuilder.append(charStack.removeLast());
        }

        return stringBuilder.toString();
    }

}
