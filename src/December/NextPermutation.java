package December;

import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2021-12-22
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n == 1) return;
        int tmp;
        for(int i = n - 1;i > 0;i--){
            if(nums[i] > nums[i - 1]){
                Arrays.sort(nums,i,n);
            }
            for(int j = i;j < n;j++){
                if(nums[i - 1]  < nums[j]){
                    tmp = nums[j];
                    nums[j] = nums[i - 1];
                    nums[i - 1] = tmp;
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }
}
