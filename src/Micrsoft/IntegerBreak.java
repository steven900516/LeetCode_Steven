package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-01-17
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        int dp[] = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1;j < i - 1;j++){
                dp[i] = Math.max(dp[i],Math.max(j * (i - j),j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
