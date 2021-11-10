package company;

/**
 * @author Steven0516
 * @create 2021-11-09
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums){
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i],dp[i - 1] + nums[i]);
        }


        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            Math.max(res,dp[i]);
        }

        return res;
    }
}
