package December;

import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2021-12-16
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        if(m == 1 && n == 1){
            return grid[0][0];
        }


        for(int i = 0;i < n;i++){
            if(i == 0){
                dp[0][i] = grid[0][i];
            }else{
                dp[0][i] = dp[0][i - 1] + grid[0][i];
            }
        }

        for(int i = 1;i < m;i++){
            if(i == 0){
                dp[i][0] = dp[i][0];
            }else{
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }

        }

        for(int i = 1;i < m;i ++){
            for(int j = 1;j < n;j++){
                dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - 1])  + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];

    }
}
