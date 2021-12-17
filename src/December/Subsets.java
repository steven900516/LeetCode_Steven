package December;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2021-12-17
 */
public class Subsets {

    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        if(nums.length == 1){
            res.add(path);
            path.add(nums[0]);
            res.add(path);
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            backTrack(nums,path,i,0);
        }

        return res;
    }

    private void backTrack(int[] nums, LinkedList<Integer> path,int count,int index) {
        if(path.size() == count){
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backTrack(nums, path, count, i + 1);
            path.remove(nums[i]);
        }
    }
}
