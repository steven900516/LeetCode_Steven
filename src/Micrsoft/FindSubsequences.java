package Micrsoft;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author Steven0516
 * @create 2022-01-06
 */
public class FindSubsequences {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        if(nums.length == 1 ){

            return res;
        }
        backTrack(nums,0,path);
        return res;
    }

    private void backTrack(int[] nums, int index, LinkedList<Integer> path) {
        if(path.size() >= 2){
            res.add(new LinkedList<>(path));
        }

        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if(set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);
            if(index == 0 || nums[index - 1] <= nums[i]){
                path.add(nums[i]);
                backTrack(nums,i + 1,path);
                path.removeLast();
            }
        }

    }
}
