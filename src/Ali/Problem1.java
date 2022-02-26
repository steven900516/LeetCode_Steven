package Ali;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Steven0516
 * @create 2022-02-25
 */

/*
/ *
给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。

示例 1：
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

示例 2：
输入：nums = [3,2,4], target = 6
输出：[1,2]

示例 3：
输入：nums = [3,3], target = 6
输出：[0,1]
* /


class Solution {
    public int[] twoSum(int[] nums, int target) {

    }
}


 */

public class Problem1 {

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < n; i++) {
            res[0] = i;
            if(map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i){
                res[1] = map.get(target - nums[i]);
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        for (Integer a : twoSum(new int[]{3,3}, 6)){
            System.out.println(a);
        }
    }
}
