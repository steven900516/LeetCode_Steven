package labuladong.BackTrack;

/**
 * @author Steven0516
 * @create 2021-10-25
 */
public class FindTargetSumWays {
    int res = 0;
    public int findTargetSumWays(int[] nums, int target) {
        backTrack(0,nums,target,0);
        return res;
    }

    private void backTrack(int i,int[] nums,int target,int sum){
        if(i == nums.length){
            if(sum == target){
                res++;
            }
            return;
        }

        sum += nums[i];
        backTrack(i + 1,nums,target,sum);
        sum -= nums[i];

        sum -= nums[i];
        backTrack(i + 1,nums,target,sum);
        sum += nums[i];
    }
}
