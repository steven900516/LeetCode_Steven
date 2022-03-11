package March;

import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2022-03-08
 */
public class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int res = -1;
        for(int i = 1;i < n;i++){
            if(nums[i] > nums[i - 1]){
                dp[i] = dp[i - 1] + 1;
            }
        }
        for(int i = 0;i < n;i++){
            res = Math.max(res,dp[i]);
        }

        return res;
    }
}
