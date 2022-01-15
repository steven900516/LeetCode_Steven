package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-01-15
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        if(n <= 1) return dp[n];
        for(int i = 2;i <= n;i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
