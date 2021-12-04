package company;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2021-11-18
 */
public class GenerateParenthesis {
    LinkedList<String> res = new LinkedList<String>();
    int n;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        helper("",0,0);
        return res;
    }

    public void helper(String cur,int left,int right){
        if(left == right && left == n){
            res.add(cur);
        }
        if(left > n ||left < right){
            return;
        }

        helper(cur + "(",left + 1,right);
        helper(cur + ")",left,right + 1);
    }

}
