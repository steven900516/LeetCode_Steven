package labuladong.Dynamic;

/**
 * @author Steven0516
 * @create 2021-11-04
 */
public class MaxProfit3 {
    public int maxProfit(int[] prices) {

        int n = prices.length;
        int k = 3;
        int[][][] dp = new int[n][k][2];

        for (int i = 0; i < n; i++) {
            for (int j = k; k > 0; k--) {
                if(i - 1 < 0){
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
            }
        }

        return dp[n - 1][k][0];
    }
}
