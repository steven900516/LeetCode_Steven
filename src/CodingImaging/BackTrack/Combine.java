package CodingImaging.BackTrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2021-12-26
 */
public class Combine {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> path = new LinkedList<>();
        backTrack(1,n,k,path);
        return res;
    }


    public void backTrack(int index,int n,int k,LinkedList<Integer> path){
        if(path.size() == k){
            res.add(new LinkedList<>(path));
            return;
        }

        for(int i = index;i <= n;i++){
            path.add(i);
            backTrack(i + 1,n,k,path);
            path.removeLast();
        }
    }
}
