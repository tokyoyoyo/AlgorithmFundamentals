package com.que;

import java.util.*;

public class TurntableLock {
    public int openLock(String[] deadends, String target) {

        if(target.equals("0000") ){       //答案就是初始状态，需要拨动零次，返回0
            return 0;
        }

        int step = 0;   //记录拨动次数
        Set<String> deads = new HashSet();  //deadend放到hashset,方便判断当前状态是否为deadend,不然要遍历

        for (String deadend : deadends) {   //deadend放到hashset
            deads.add(deadend);
        }

        if(deads.contains("0000")){     //deadend中有初始状态的话说明无法旋转到目标数字且不被锁定。返回-1；
            return -1;
        }

        Queue<String> queue = new LinkedList<>();   //创建队列，并将初始状态入队
        queue.offer("0000");

        Set<String> tried = new HashSet<>();    //创建一个hashSet来存储已经尝试过的密码
        tried.add("0000");

        while (!queue.isEmpty()){
            //  队中的是上一次循环已经访问过的所有状态，每次循环，判断这些状态的相邻状态是否有为target，
            // 有的话返回step,不是的话把相邻状态添加到队列。（前提是相邻状态还没进队列）
            ++step;
            int size = queue.size();    //要先把队列长度保存下来，不能在for中直接用queue.size（）,因为队列长度会变化

            for (int i = 0; i < size ; i++) {
                String status = queue.poll();

                for ( String neighbor : getNeighbors(status)) {
                    if(!tried.contains(neighbor) && !deads.contains(neighbor)){

                        if(neighbor.equals(target)){    //如果扭到target了，返回step
                            return step;
                        }
                        queue.offer(neighbor);
                        tried.add(neighbor);
                    }
                }  //for ( String neighbor : getNeighbors(status))
            }//for (int i = 0; i < size ; i++)
        }//while (!queue.isEmpty())

        //循环结束，说明所有可能都遍历了，并且没有得到target,说明无法旋转到目标数字且不被锁定。返回-1；
        return -1;
    }

    char goAhead(char c){
        return c == '0' ? '9' : (char)(c - 1);   //向前拨动数字
    }

    char goBack(char c){
        return c == '9' ? '0' : (char) (c + 1);     //向后拨动数字
    }

    List<String> getNeighbors(String str){      //获取当前状态的八个相邻状态
        char[] arr = str.toCharArray();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {  //一共四位，每一位有前后两个邻居，轮流获取相邻状态

            char letter = arr[i];       //获取当前位

            arr[i] = goAhead(letter);       //将前后两个相邻状态加入列表
            list.add(new String(arr));

            arr[i] = goBack(letter);
            list.add(new String(arr));

            arr[i] = letter;        //复原当前位
        }
        return list;
    }
}
