package company;

/**
 * @author Steven0516
 * @create 2021-11-07
 */
public class Trap {
    public int trap(int[] height) {
        int n = height.length;
        int[][] dp = new int[n][2];
        if(n <= 2) return 0;

        dp[0][0] = height[0];
        dp[n - 1][1] = height[n - 1];

        for (int i = 1; i < n - 1; i++) {
            dp[i][0] = Math.max(height[i], dp[i - 1][0]);
            dp[n - i - 1][1] = Math.max(height[n - i - 1], dp[n - i][1]);
        }

        int sum = 0;
        for (int i = 1; i < n - 1; i++) {
            sum += Math.min(dp[i][0], dp[i][1]) - height[i];
        }

        return sum;

    }
}
