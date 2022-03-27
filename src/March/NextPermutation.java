package March;

import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2022-03-27
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for (int i = nums.length - 1;i > 0;i--){
            if (nums[i] > nums[i - 1]){
                Arrays.sort(nums,i,n);
                for (int j = i; j < n; j++) {
                    if (nums[j] > nums[i]){
                        int tmp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = tmp;
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);

    }
}
