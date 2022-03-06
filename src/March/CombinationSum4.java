package March;

/**
 * @author Steven0516
 * @create 2022-03-06
 */
public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
//        dp[i]: 凑成目标正整数为i的排列个数为dp[i]
        for (int i = 0; i <= target; i++) {
            for (int j = 0;j < nums.length;j++){
                if(i - nums[j] >= 0){
                    dp[i] += dp[i - nums[j]];
                }
            }
        }

        return dp[target];
    }
}