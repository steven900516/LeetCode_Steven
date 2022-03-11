package March;

/**
 * @author Steven0516
 * @create 2022-03-09
 */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        int i = 0;

        while(i < nums.length){
            if(i == nums[i]){
                i++;
                continue;
            }
            if(nums[i] == nums[nums[i]]){
                return nums[i];
            }
            int tmp = nums[i];
            nums[i] = nums[nums[i]];
            nums[tmp] = tmp;
        }

        return -1;
    }
}
