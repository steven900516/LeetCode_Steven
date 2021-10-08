package leetcode;

import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2021-09-10
 */


//数组中重复的数字
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        int tmp = nums[0];
//        [1,2,3,3,4,5,5,6,7]
        for (int i = 1; i < nums.length; i++) {
            if(tmp == nums[i]){
                return tmp;
            }else{
                tmp = nums[i];
            }
        }
        return tmp;
    }

    public static void main(String[] args) {
        FindRepeatNumber findRepeatNumber = new FindRepeatNumber();
        int[] ints = new int[]{1,2,3,3,4,5,5,6,7};
        System.out.println(findRepeatNumber.findRepeatNumber(ints));
    }
}
