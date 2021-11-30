package company;

/**
 * @author Steven0516
 * @create 2021-11-30
 */
public class LengthOfLIS2 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i  =  0;i < n;i++){
            dp[i] = 1;
        }

        for(int i = 0;i < n;i++){
            for(int j = 0;j < i;j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }

        int res = -1;
        for(int i = 0;i < dp.length;i++){
            res = Math.max(res,dp[i]);
        }

        return res;
    }
}
