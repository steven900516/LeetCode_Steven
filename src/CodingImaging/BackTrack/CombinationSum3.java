package CodingImaging.BackTrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2021-12-26
 */
public class CombinationSum3 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        LinkedList<Integer> path = new LinkedList<>();
        backTrack(1,k,n,path);
        return res;
    }

    public void backTrack(int index,int k,int n,LinkedList path){
        if(n < 0) return;
        if(path.size() == k && n == 0){
            res.add(new LinkedList<>(path));
            return;
        }


        for(int i = index;i <= 9;i++){
            if(path.contains(i)) continue;
            path.add(i);
            backTrack(i + 1,k,n - i,path);
            path.removeLast();
        }
    }
}
