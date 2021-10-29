package labuladong.Dynamic;

import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2021-10-29
 */
public class MinPathSum {
    int[][] dp2;

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0;i < n;i++){
            if(i == 0){
                dp[0][0] = grid[0][0];
            }else{
                dp[0][i] = dp[0][i - 1] + grid[0][i];
            }
        }

        if (m > 1)
            for(int i  = 1;i < m;i++){
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }

        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j],dp[i][j - 1] + grid[i][j]);
            }
        }

        return dp[m - 1][n - 1];
    }

    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp2 = new int[m][n];
        for(int[] row: dp2){
            Arrays.fill(row,-1);
        }

        return backTrack(grid,m - 1, n -  1);
    }

    private int backTrack(int[][] grid, int m, int n) {
        if(m == 0 && n == 0){
            return grid[0][0];
        }

        if(m < 0 || n < 0){
            return Integer.MAX_VALUE;
        }

        if(dp2[m][n] != -1){
            return dp2[m][n];
        }

        return Math.max(backTrack(grid,m - 1,n),backTrack(grid,m,n - 1)) + grid[m][n];

    }

}
