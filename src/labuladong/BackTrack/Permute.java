package labuladong.BackTrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2021-10-19
 */
public class Permute {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 1){
            LinkedList<Integer> path = new LinkedList<>();
            path.add(nums[0]);
            res.add(path);
            return  res;
        }
        LinkedList<Integer> path = new LinkedList<>();

        back(path,nums);

        return res;
    }
    void back(LinkedList<Integer> path, int[] nums){

        if(path.size() ==  nums.length){
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(path.contains(nums[i])){
                continue;
            }
            path.add(nums[i]);
            back(path,nums);
            path.removeLast();
        }
    }
}
