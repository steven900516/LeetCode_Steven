package Micrsoft;

import java.util.Stack;

/**
 * @author Steven0516
 * @create 2022-01-26
 */
public class EvalRPN {
    Stack<Integer> numberStack = new Stack<>();

    public int evalRPN(String[] tokens) {
        int res = 0;
        for (int i = 0; i < tokens.length; i++) {
            if(isDigit(tokens[i])){
                numberStack.push(Integer.parseInt(tokens[i]));
            }else{
                int ans = 0;
                Integer num1 = numberStack.pop();
                Integer num2 = numberStack.pop();
                switch (tokens[i]){
                    case "+":{
                        ans = num1 + num2;
                        break;
                    }
                    case "-":{
                        ans = num1 - num2;
                        break;
                    }
                    case "*":{
                        ans = num1 * num2;
                        break;
                    }
                    case "/":{
                        ans = num2 / num1;
                        break;
                    }
                }
                numberStack.push(ans);
            }
        }
        return numberStack.peek();
    }

    private boolean isDigit(String token) {
        if(token.equals("*") || token.equals("-") || token.equals("+") || token.equals("/")) return false;
        return true;
    }


}
