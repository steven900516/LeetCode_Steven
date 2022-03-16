package March;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Steven0516
 * @create 2022-03-16
 */
public class IsValid {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(map.containsKey(cur)){
                if(stack.isEmpty() || map.get(cur) != stack.peek()){
                    return false;
                }else{
                    stack.pop();
                }
            }else {
                stack.add(cur);
            }
        }
        return stack.isEmpty();
    }
}
