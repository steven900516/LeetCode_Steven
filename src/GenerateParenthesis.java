import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-08-03 8:59
 */
public class GenerateParenthesis {
    ArrayList<String> list = new ArrayList<>();
    int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        helper("",0,0);
        return list;

    }

    private void helper(String curr, int left, int right) {
        if(left == n && right ==n){
            list.add(curr);
        }

        if(left > n ||left < right){
            return;
        }

        helper(curr + "(" ,left + 1,right);
        helper(curr + ")" ,left,right + 1);
    }


    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(3));
    }
}
