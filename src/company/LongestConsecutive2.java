package company;

import java.util.HashSet;

/**
 * @author Steven0516
 * @create 2021-11-24
 */
public class LongestConsecutive2 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for(Integer s: set){
            if(set.contains(s - 1)){
                continue;
            }else{
                int len = 0;
                while(set.contains(s++)){
                    len++;
                }
                res = Math.max(res,len);
            }
        }
        return res;
    }
}
