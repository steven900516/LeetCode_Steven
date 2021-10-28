package labuladong.Dynamic;

/**
 * @author Steven0516
 * @create 2021-10-28
 */
public class CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int eve: nums){
            sum += eve;
        }

        if(sum % 2 == 0){
            return false;
        }

        int m = nums.length;
        int n = sum / 2;
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0]  = true;
        }

        for (int i = 0; i <= n;i++){
            dp[0][i] = false;
        }


        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n; j++) {
                if(j - nums[i - 1] < 0){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j] ||dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[m][n];
    }
}
