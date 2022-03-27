package March;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Steven0516
 * @create 2022-03-27
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else{
                    res = Math.max(res,i - stack.peek());
                }
            }
        }
        return res;
    }
}
