package Ali;

/**
 * @author Steven0516
 * @create 2022-03-03
 */
public class CanPartition {

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0){
            return false;
        }

        boolean[][] dp = new boolean[n + 1][sum / 2 + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= dp.length; i++) {
            for (int j = 1; j <= dp[0].length; j++) {
                if(j - nums[j - 1] < 0){
                    dp[i][j] = dp[i][j - 1];
                }else{
                    dp[i][j] = dp[i][j - 1] || dp[i][j - nums[j - 1]];
                }
            }
        }

        return dp[n][sum / 2];
    }
}
