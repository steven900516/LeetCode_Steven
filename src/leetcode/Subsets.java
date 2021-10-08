package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2021-08-16
 */
public class Subsets {
    public List<List<Integer>> backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        List<Integer> tempsubset = new ArrayList<>();
        for(int size =  0;size <= nums.length; size ++){
            backtrack(0,size,tempsubset,allSubsets,nums);
        }
        return allSubsets;
    }

    private void backtrack(int index ,int size,List<Integer> tempsubset,List<List<Integer>> allSubsets,int[] nums){
        if(tempsubset.size() == size){
            allSubsets.add(tempsubset);
            return;
        }

        for(int i = 0;i < nums.length;i++){
            tempsubset.add(nums[i]);
            backtrack(index + 1,size,tempsubset,allSubsets,nums);
            tempsubset.remove(tempsubset.size() - 1);
        }
    }


}
