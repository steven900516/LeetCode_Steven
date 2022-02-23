package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-02-23
 */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while(i  < nums.length){
            if(i == nums[i]){
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]){
                return nums[i];
            }
            int tmp = nums[i];
            nums[i] = nums[nums[i]];
            nums[nums[i]] = tmp;
        }
        return -1;
    }

}
