package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-01-22
 */
public class FindTargetSumWays {
    int res = 0;
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length == 0) return res;
        dinfHelper(nums,target,0);
        return res;
    }

    private void dinfHelper(int[] nums, int rest, int index) {
        if(index == nums.length){
            if(rest == 0){
                res++;
            }
            return;
        }

        rest += nums[index];
        dinfHelper(nums,rest,index  + 1);
        rest -= nums[index];

        rest -= nums[index];
        dinfHelper(nums,rest,index + 1);
        rest += nums[index];
    }
}
