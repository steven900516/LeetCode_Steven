package Micrsoft;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2022-02-16
 */
public class SubsetsAgain {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length == 0){
            return res;
        }
        for (int i = 1; i <= nums.length ; i++) {
            LinkedList<Integer> path = new LinkedList<>();
            recur(i,path,0,nums);
        }
//        Integer.MAX_VALUE
        return res;
    }

    private void recur(int target, LinkedList<Integer> path, int index,int[] nums) {
        if(path.size() == target){
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            recur(target, path, i + 1, nums);
            path.removeLast();
        }
    }
}
