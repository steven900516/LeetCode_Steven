package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-02-21
 */
public class Rob {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 2];
        for (int i = n - 1; i >= 0 ; i++) {
            dp[i] = Math.max(dp[i + 1],nums[i] + dp[i + 2]);
        }

        return dp[0];
    }
}
