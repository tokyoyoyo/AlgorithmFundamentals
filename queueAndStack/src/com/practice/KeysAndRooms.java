package com.practice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @projectName: AlgorithmFundamentals
 * @className: KeysAndRooms
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/7/31 22:28
 * @version: 1.0
 */

public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int num = rooms.size();

        Deque<Integer> queue = new ArrayDeque<>();  //BFS用的工具队列
        boolean[] visited = new boolean[num];

        visited[0] =  true;
        int count = 1;

        for (Integer key :  rooms.get(0)){
            queue.offer(key);
        }

        while (!queue.isEmpty()){
            int roomNum = queue.poll();
            if(!visited[roomNum]){
                visited[roomNum] =true;
                count++;
            }

            for (Integer key :  rooms.get(roomNum)){
                if (!visited[key]){
                    queue.offer(key);
                }
            }
        }
        return count == num;
    }

}
