package December;

/**
 * @author Steven0516
 * @create 2021-12-09
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        for(int i = 0;i < nums.length;i++){
            dp[i] = nums[i];
            if(i >= 1){
                dp[i] = Math.max(dp[i],dp[i - 1] + nums[i]);
            }
        }

        int res = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++){
            res = Math.max(dp[i],res);
        }
        return res;
    }
}
