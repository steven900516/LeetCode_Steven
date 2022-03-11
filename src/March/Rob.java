package March;

/**
 * @author Steven0516
 * @create 2022-03-08
 */
public class Rob {
    public int rob(int[] nums) {
        int n = nums.length;
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1] > nums[0] ? nums[1] : nums[0];


        for(int i = 2;i < n;i++){
            dp[i] = Math.max(dp[i - 1],dp[i - 2] + nums[i]);
        }

        return dp[n - 1];
    }
}
