package March;

/**
 * @author Steven0516
 * @create 2022-03-27
 */
public class Trap {
    public int trap(int[] height) {
        int n = height.length;
        int[][] dp = new int[n][2];
        dp[0][0] = height[0];
        dp[n - 1][1] = height[n - 1];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],height[i]);
        }
        for (int i = n - 2; i >= 0 ; i--) {
            dp[i][1] = Math.max(dp[i + 1][1],height[i]);
        }
        for (int i = 1; i < n ; i++) {
            ans += Math.min(dp[i][0],dp[i][1]) - height[i];
        }

        return ans;
    }
}
