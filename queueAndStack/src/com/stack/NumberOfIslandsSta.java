package com.stack;


public class NumberOfIslandsSta {

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

                    Dfs(grid,r,c);
                    ++islandNumber;

                }// if(grid[r][c] == '1')
            }
        }//双层for
        return islandNumber;
    }

    private void Dfs(char[][] grid, int i , int j){
        if( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;

        grid[i][j] = '0';
        Dfs(grid,i-1, j);
        Dfs(grid,i+1, j);
        Dfs(grid,i,j-1);
        Dfs(grid,i,j+1);
    }

}
