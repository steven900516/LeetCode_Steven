package company;

import java.util.HashMap;

/**
 * @author Steven0516
 * @create 2021-11-05
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1'){
                    dfs(i,j,grid);
                    count ++ ;
                }
            }
        }
        return count;
    }

    private void  dfs(int row,int column,char[][] grid) {
        if(row  < 0|| column < 0 || row >= grid.length || column >= grid[0].length || grid[row][column] == '0'){
            return;
        }
        grid[row][column] = '0';
        dfs(row,column - 1,grid);
        dfs(row - 1,column,grid);
        dfs(row,column + 1,grid);
        dfs(row + 1,column,grid);
    }


}
