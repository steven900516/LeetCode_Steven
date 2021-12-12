package December;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2021-12-11
 */
public class GenerateParenthesis {
    int n;
    List<String> res = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        this.n = n;
        helper("",0,0);
        return res;
    }

    private void helper(String s, int left, int right) {
        if(left == right && left == n){
            res.add(s);
            return;
        }

        if(left > n || left < right){
            return;
        }

        helper(s + "(", left + 1,right);
        helper(s + ")" , left,right + 1);
    }
}
