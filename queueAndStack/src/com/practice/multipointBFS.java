package com.practice;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @projectName: AlgorithmFundamentals
 * @className: multipointBFS
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/7/31 21:17
 * @version: 1.0
 */

public class multipointBFS {

    public int[][] updateMatrix(int[][] mat) {

        int row = mat.length;
        int column = mat[0].length; //行列

        boolean[][] visited = new boolean[row][column]; //标记是否访问过
        int[][] distance = new int[row][column];    //答案数组

        Queue<int[]> queue = new LinkedList<>();    //工作队列

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < row; i++) {     //将所有0加入队列
            for (int j = 0; j < column; j++) {
                if(mat[i][j] == 0){
                    queue.offer( new int[] {i,j});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()){
            int[] dot = queue.poll();   //从数组中取出的坐标

            int i = dot[0],j = dot[1];

            for (int k = 0; k < 4; k++) {
                int x = i + dirs[k][0];
                int y = j + dirs[k][1];

                if(  x < row && x >= 0 && y < column && y >= 0 && !visited[x][y]  ){
                    visited[x][y] = true;
                    distance[x][y] = distance[i][j]+1;
                    queue.offer(new int[] {x,y});
                }
            }
        }

        return distance;
    }
}
