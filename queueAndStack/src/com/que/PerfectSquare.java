package com.que;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//https://leetcode-cn.com/leetbook/read/queue-stack/kfgtt/


public class PerfectSquare {

    public int numSquares(int n) {

        Queue<Integer> queue = new LinkedList<>();   //一个队列，用于保存层次遍历中一层的数据

        Set<Integer> visited = new HashSet<>(); //一个集合，用于存放访问过的节点，避免重复访问

        queue.offer(0); //将根节点0加入队列和集合
        visited.add(0);

        int level = 0;  //记录访问到了第几层，把根节点当作第0层

        while (!queue.isEmpty()){
            level++;   //每轮循环，访问的层数加一，level也加一

            //根据队列中的上一次元素，访问这一层元素
            int size = queue.size();

            for (int i = 0; i < size; i++) {    //用for遍历上一层元素
                int fatherNodeValue = queue.poll();

                for (int j = 1; j < n; j++) {
                    int childNodeValue = fatherNodeValue + j*j;

                    if (childNodeValue == n){   //字节点始终是完全平方数的和，当他等于n，返回当前层数，结束运算
                        return level;   //程序一定从这里结束
                    }
                    if(childNodeValue > n){     //字节点始终是完全平方数的和，当他大于n终止内层循环
                        break;
                    }

                    if(!visited.contains(childNodeValue)){      //如果子节点既不满足要求，也不到跳出循环的时候，并且子节点没被访问过
                        queue.offer(childNodeValue);    //加入队列，作为下一次while循环的父节点
                        visited.add(childNodeValue);    //加入集合，方便确认是否访问过
                    }
                }//for (int j = 1; j < n; j++),制造子节点
            }//for (int i = 0; i < size; i++)遍历父节点
        }//while (!queue.isEmpty())
        return level;
    }

}