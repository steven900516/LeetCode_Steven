package labuladong.Dynamic;

/**
 * @author Steven0516
 * @create 2021-10-28
 */
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if((j - coins[i - 1]) >= 0){
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }
}
