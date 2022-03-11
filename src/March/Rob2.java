package March;

/**
 * @author Steven0516
 * @create 2022-03-08
 */
public class Rob2 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        if(n == 2){
            return nums[1] > nums[0] ? nums[1] : nums[0];
        }
        int[] dp1 = new int[n];
        dp1[0] = nums[0];
        dp1[1] = nums[1] > nums[0] ? nums[1] : nums[0];
        for(int i = 2;i < n - 1;i++){
            dp1[i] = Math.max(dp1[i - 1],dp1[i - 2] + nums[i]);
        }
        int[] dp2 = new int[n];
        dp2[1] = nums[1];
        dp2[2] = nums[1] > nums[2] ? nums[1] : nums[2];
        for(int i = 3;i < n;i++){
            dp2[i] = Math.max(dp2[i - 1],dp2[i - 2] + nums[i]);
        }
        return dp1[n - 2] > dp2[n - 1] ? dp1[n - 2] : dp2[n - 1];
    }
}
