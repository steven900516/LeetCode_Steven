package CodingImaging.BinaryTree;

/**
 * @author Steven0516
 * @create 2021-12-26
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int[] dp = new int[n];
        for(int i = 0;i < n;i++){
            dp[i] = nums[i];
        }

        for(int i = 1;i < n;i++){
            dp[i] = Math.max(dp[i - 1] + nums[i] , dp[i]);
        }

        int res = nums[0];
        for(int i = 0;i < n;i++){
            res = Math.max(res,dp[i]);
        }

        return res;

    }
}
