package labuladong.Dynamic;

/**
 * @author Steven0516
 * @create 2021-10-23
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int target = Integer.MAX_VALUE;
        int left = 0;
        int index = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < target){
                target = nums[i];
            }
        }
        while(left <= right){
            int mid = left + (right - left) / 2 ;
            if(nums[mid] == target){
                index = mid;
                break;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        return 1;
    }
}
