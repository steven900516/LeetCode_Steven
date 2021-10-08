package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Steven0516
 * @create 2021-09-29
 */

//数组中出现次数超过一半的数字
public class MajorityElement {
    //哈希表法
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> count = new HashMap<Integer,Integer>();
        for(int i = 0;i < nums.length ;i++){
            if(count.containsKey(nums[i])){
                count.put(nums[i],count.get(nums[i]) + 1);
                Integer cts = count.get(nums[i]);
                if(cts > nums.length / 2){
                    return nums[i];
                }
            }else{
                count.put(nums[i],1);
            }
        }
        return 0;
    }


    //数组排序法
    public int majorityElement2(int[] nums){
        Arrays.sort(nums);
        return  nums[nums.length/2];
    }
}
