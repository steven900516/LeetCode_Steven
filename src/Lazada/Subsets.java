package Lazada;

import java.util.LinkedList;
import java.util.List;

public class Subsets {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0){
            return res;
        }
        res.add(new LinkedList<>());

        for (int i = 1; i <= nums.length ; i++) {
            LinkedList<Integer> path = new LinkedList<>();
            recur(path,i,0,nums);
        }

        return res;
    }

    private void recur(LinkedList<Integer> path, int length, int index,int[] nums) {
        if (path.size() == length){
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = index; i < length; i++) {
            path.add(nums[i]);
            recur(path, length, index + 1, nums);
            path.removeLast();
        }

    }
}
