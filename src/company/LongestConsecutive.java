package company;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Steven0516
 * @create 2021-11-21
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int ints: nums){
            set.add(ints);
        }
        int res = 0;
        for(int eve: set){
            if(set.contains(eve - 1)){
                continue;
            }else{
                int len = 0;
                while(set.contains(eve++))
                    len++;
                res = Math.max(res,len);
            }
        }
        return res;
    }
}
