package labuladong.Dynamic;

/**
 * @author Steven0516
 * @create 2021-10-27
 */
public class MinimumDeleteSum {


    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int dp[][] = new int[m + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            dp[0][i] += dp[0][i - 1] +  s2.charAt(i - 1);
        }

        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i -1);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j -1];
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 2),dp[i][j -1] + s2.charAt(j - 2));
                }
            }
        }

        return dp[m][n];
    }
}
