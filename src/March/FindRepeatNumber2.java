package March;

import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2022-03-28
 */
public class FindRepeatNumber2 {
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i < n){
            if (i == nums[i]){
                i++;
                continue;
            }

            if (nums[i] == nums[nums[i]]){
                return nums[i];
            }
            int tmp = nums[i];
            nums[i] = nums[nums[i]];
            nums[tmp] = tmp;
            System.out.println(Arrays.toString(nums));
        }

        return -1;
    }
}
