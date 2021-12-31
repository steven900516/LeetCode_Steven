package CodingImaging.BackTrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2021-12-31
 */
public class CombinationSum {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0){
            return res;
        }
        LinkedList<Integer> path = new LinkedList<>();
        backTrack(path,candidates,target,0);
        return res;
    }

    private void backTrack(LinkedList<Integer> path, int[] candidates,int target,int index) {
        if(target == 0){
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            int sub = target - candidates[i];

            if(sub < 0) continue;
            System.out.println("递归前->" + path + sub);
            path.add(candidates[i]);
            backTrack(path, candidates,sub,i);
            path.removeLast();
            System.out.println("递归后->" + path );
        }
    }
}
