package March;

import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2022-03-09
 */
public class QQ {

    public static int test(int[] nums){
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = nums[0] % 3 == 0 ? nums[0] : 0;
        for (int i = 1; i < n; i++) {
            int sum = nums[i] + nums[i - 1];
            if((dp[i - 1] + nums[i]) % 3 == 0 ) {
                dp[i] = dp[i - 1] + nums[i];
            }else if(sum % 3 == 0){
                dp[i] = Math.max(dp[i],dp[i - 1] + sum);
            }else{
                dp[i] = dp[i - 1];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] test = {3,6,5,1,8};
        System.out.println(test(test));
    }
}
