package March;

/**
 * @author Steven0516
 * @create 2022-03-11
 */
public class CuttingRope {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for(int i = 3;i <= n ;i++){
            for(int j = 1;j < i;j++){
                dp[i] = Math.max(dp[i - j] * j,Math.max(dp[i],j * (i -j)));
            }
        }
        return dp[n];
    }
}
