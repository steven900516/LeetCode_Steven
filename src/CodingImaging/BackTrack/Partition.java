package CodingImaging.BackTrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2021-12-31
 */
public class Partition {
    List<List<String>> res = new LinkedList<>();
    public List<List<String>> partition(String s) {
        if(s.length() == 0){
            return res;
        }
        LinkedList<String> path = new LinkedList<>();
        backTrack(s,0,path);
        return res;
    }

    private void backTrack(String s, int end, LinkedList<String> path) {
        if(end >= s.length()){
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = end; i < s.length(); i++) {
            String tmp = s.substring(end,i + 1);
            if(isParam(tmp)){
                path.add(tmp);
                backTrack(s,i + 1,path);
                path.removeLast();
            }
        }
    }

    public boolean isParam(String s){
        int n = s.length();
        if(n == 0) return false;
        if(n == 1) return true;
        for(int i = 0;i < n / 2;i++){
            if(s.charAt(i) != s.charAt(n - i - 1)){
                return false;
            }
        }
        return true;
    }

}
