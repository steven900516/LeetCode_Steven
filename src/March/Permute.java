package March;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2022-03-22
 */
public class Permute {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length  == 0){
            return res;
        }
        LinkedList<Integer> path = new LinkedList<>();
        recur(nums,path);
        return res;
    }

    private void recur(int[] nums, LinkedList<Integer> path) {
        if(path.size() == nums.length){
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(path.contains(nums[i])) continue;
            path.add(nums[i]);
            recur(nums,path);
            path.removeLast();
        }
    }
}
