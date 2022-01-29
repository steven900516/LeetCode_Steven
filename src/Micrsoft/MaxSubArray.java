package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-01-29
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
        }
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i],dp[i - 1] + nums[i]);
        }
        return dp[n - 1];
    }
}
