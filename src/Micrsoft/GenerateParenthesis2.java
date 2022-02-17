package Micrsoft;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2022-02-17
 */
public class GenerateParenthesis2 {
    LinkedList<String> res = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        helper(n,0,0,"");
        return res;
    }

    private void helper(int n, int left, int right, String s) {
        if(left > n ||right > left ){
            return;
        }
        if(left == n && left == right){
            res.add(s);
            return;
        }
        helper(n,left + 1,right,s + "(");
        helper(n,left ,right + 1,s + ")");
    }
}
