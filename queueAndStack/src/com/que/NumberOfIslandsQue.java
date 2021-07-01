package com.que;


import java.util.ArrayDeque;
//BFS
public class NumberOfIslandsQue {
    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int nr = grid.length;  //row  行数
        int nc = grid[0].length;  //colnmn 列数
        int islandNumber = 0;   //统计岛屿数量


        for( int r = 0 ; r < nr ; ++r){
            for( int c = 0 ; c < nc ; ++c){         //双层循环，确保每个元素被遍历
                if(grid[r][c] == '1'){      //如果摸到了岛屿，岛屿数量加一，通过BFS遍历整个岛屿并且标记。表示该岛屿已经被计数过。避免重复计数
                    ArrayDeque<Integer> neighbors = new ArrayDeque<>();
                    neighbors.add( r * nc + c  );   //用id保存元素的行标和列标
                    grid[r][c] = '2';   //访问过的岛屿就置为二，方便区分是否访问过，如果置为0就和水区分不开了,入队时就置为2，如果出队时才置为2，一个元素可能重复入队
                    ++islandNumber;

                    while (!neighbors.isEmpty()){       //当队列不为空,通过BFS遍历整个岛屿并且标记,队列为空了，说明整块岛屿遍历完了
                        int id  = neighbors.remove();
                        int row = id / nc;
                        int colnmn = id % nc;

                        //将正在处理的岛屿四周的未访问过岛屿也加进队列
                        if(row-1 >=0  && grid[row-1][colnmn] == '1'){    //判断上方元素是否应入队
                            neighbors.add(colnmn + nc * (row-1) );
                            grid[row-1][colnmn] = '2';   //如果出队时才置为2，一个元素可能重复入队
                        }

                        if(row+1 < nr && grid[row+1][colnmn] == '1'){  //判断下方元素是否应入队
                            neighbors.add(colnmn + nc * (row+1) );
                            grid[row+1][colnmn] = '2';   //如果出队时才置为2，一个元素可能重复入队
                        }

                        if(colnmn-1 >=0 && grid[row][colnmn-1] == '1'){   //判断左方元素是否应入队
                            neighbors.add(colnmn-1 + row * nc );
                            grid[row][colnmn-1] = '2';   //如果出队时才置为2，一个元素可能重复入队
                        }

                        if(colnmn+1 < nc && grid[row][colnmn+1] == '1'){   //判断右方元素是否应入队
                            neighbors.add(colnmn+1 + row * nc );
                            grid[row][colnmn+1] = '2';   //如果出队时才置为2，一个元素可能重复入队
                        }

                    }//while (!neighbors.isEmpty())
                }// if(grid[r][c] == '1')
            }
        }//双层for
        return islandNumber;
    }
}
