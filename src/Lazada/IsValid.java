package Lazada;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValid {

    Map<Character, Character> map = new HashMap<Character, Character>() {{
        put(')', '(');
        put(']', '[');
        put('}', '{');
    }};

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                if (!stack.isEmpty() &&stack.peek() == map.get(s.charAt(i))){
                    stack.pop();
                }else {
                    return false;
                }
            }else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }
}
