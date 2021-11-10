package labuladong.Dynamic;

/**
 * @author Steven0516
 * @create 2021-11-09
 */
public class Rob {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        if(n == 2){
            return Math.max(nums[0],nums[1]);
        }
        int dp[] = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];

        //dp含义：第0-i个房间能偷窃的最大金额
        for(int i = 2;i < n;i++){
            for(int j = 0;j < i;j++){
                if(j == i - 1)  continue;
                dp[i] = Math.max(dp[j] + nums[i],dp[i]);
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
