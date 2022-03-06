package March;

/**
 * @author Steven0516
 * @create 2022-03-06
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        if(n <= 2){
            return n;
        }
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3;i <= n;i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
