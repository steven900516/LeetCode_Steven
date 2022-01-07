package Micrsoft;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2022-01-07
 */
public class Permute2 {
    List<List<Integer>> res = new LinkedList<>();
    boolean used[];
    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backTrack(nums,path);
        return res;
    }

    private void backTrack(int[] nums, LinkedList<Integer> path) {
        if(path.size() == nums.length){
            System.out.println(path);
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(used[i]) continue;
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            path.add(nums[i]);
            backTrack(nums,path);
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Permute2 permute2 = new Permute2();
        System.out.println(permute2.permuteUnique(new int[]{1, 1, 2}));
    }
}
