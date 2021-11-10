package labuladong.Dynamic;

import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2021-11-10
 */
public class Rob2 {
    int[] memo;
    int[] memo2;
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        memo = new int[n];
        Arrays.fill(memo, -1);
        Arrays.fill(memo2, -1);
        // 强盗从第 0 间房子开始抢劫
        return Math.max(dp(nums, 0,n - 2,memo),dp(nums, 1,n - 1,memo2));
    }

    public int dp(int[] nums,int start,int end,int[] memo){
        if(start >= end){
            return 0;
        }

        if(memo[start] != -1)  return memo[start];

        int res = Math.max(dp(nums, start + 1,end,memo), nums[start] + dp(nums, start + 2,end,memo));

        memo[start] = res;

        return res;
    }
}
