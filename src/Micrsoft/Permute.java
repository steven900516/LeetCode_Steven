package Micrsoft;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2022-01-07
 */
public class Permute {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        backTrack(nums,path,0);
        return res;
    }

    private void backTrack(int[] nums, LinkedList<Integer> path, int index) {
        if(path.size() == nums.length){
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(path.contains(nums[i])) continue;
            path.add(nums[i]);
            backTrack(nums,path,i + 1);
            path.removeLast();
        }
    }
}
