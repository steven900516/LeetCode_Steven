package December;

import java.util.HashMap;

/**
 * @author Steven0516
 * @create 2021-12-08
 */
public class TwoSum{
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer,Integer> res = new HashMap<>();
            for(int i = 0;i < nums.length;i++){
                if(res.containsKey(target - nums[i])){
                    return new int[]{res.get(target - nums[i]),i};
                }
                res.put(nums[i],i);
            }

            return new int[]{0,0};
        }
}
