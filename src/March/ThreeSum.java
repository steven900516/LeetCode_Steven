package March;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Steven0516
 * @create 2022-03-19
 */
public class ThreeSum {

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length == 0){
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i >= 1 && nums[i] == nums[i - 1]){
                continue;
            }
            if(nums[i] > 0){
                return ans;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum > 0){
                    right--;
                }else if(sum < 0){
                    left++;
                }if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return ans;
    }
}
