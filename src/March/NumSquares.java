package March;

import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2022-03-06
 */
public class NumSquares {
    public int numSquares(int n) {
        //和为j的完全平方数最少数量为dp[j]
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0;i <= n;i++){
            for(int j = 1;j * j <= i;j++){
                dp[i] = Math.min(dp[i - j * j] + 1,dp[i]);

            }
        }

        return dp[n];
    }
}
