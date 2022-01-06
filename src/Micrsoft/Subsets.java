package Micrsoft;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2022-01-06
 */
public class Subsets {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        res.add(path);
        for(int i = 1;i <= nums.length;i++){
            backTrack(nums,i,0,path);
        }

        return res;
    }

    private void backTrack(int[] nums, int count,int index ,LinkedList<Integer> path) {
        if(path.size() == count){
            res.add(new LinkedList<>(path));
            return;
        }

        for(int i = index;i < nums.length;i++){
            path.add(nums[i]);
            backTrack(nums,count,i + 1,path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[]{1, 2, 2}));
    }
}
