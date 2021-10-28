package labuladong.Dynamic;

import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2021-10-23
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j] ){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            Math.max(res,dp[i]);
        }

        return res;
    }
}
