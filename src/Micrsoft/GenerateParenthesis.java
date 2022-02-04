package Micrsoft;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2022-02-04
 */
public class GenerateParenthesis {
    LinkedList<String> res = new LinkedList<>();
    int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        backTrack("",0,0);
        return res;
    }

    private void backTrack(String s, int left, int right) {
        if(left > n || right > left ){
            return;
        }
        if(left == right && left == n){
            res.add(s);
        }

        backTrack(s + "(",left + 1,right);
        backTrack(s + ")",left,right + 1);
    }
}
