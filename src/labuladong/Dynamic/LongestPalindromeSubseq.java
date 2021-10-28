package labuladong.Dynamic;

/**
 * @author Steven0516
 * @create 2021-10-28
 */
public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j){
                    dp[i][j] = 1;
                    break;
                }
            }
        }
        //返回dp[0][n - 1]
        for (int i = n - 1; i >=  0; i--) {
            for (int j = i + 1; j < n; j++) {
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i + 1][j],dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
