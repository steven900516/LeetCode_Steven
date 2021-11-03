package company;

/**
 * @author Steven0516
 * @create 2021-11-02
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if(prices[i] < min){
                min = prices[i];
            }
            max = Math.max(max,prices[i] - min);
        }
        return max;
    }




    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                // 根据状态转移方程可得：
                //   dp[i][0]
                // = max(dp[-1][0], dp[-1][1] + prices[i])
                // = max(0, -infinity + prices[i]) = 0

                dp[i][1] = -prices[i];
                // 根据状态转移方程可得：
                //   dp[i][1]
                // = max(dp[-1][1], dp[-1][0] - prices[i])
                // = max(-infinity, 0 - prices[i])
                // = -prices[i]
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }
}
