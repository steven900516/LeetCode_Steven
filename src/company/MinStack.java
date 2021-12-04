package company;

import java.util.Stack;

/**
 * @author Steven0516
 * @create 2021-12-04
 */
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min_stack;
    public MinStack() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(min_stack.isEmpty() || val <= min_stack.peek()){
            min_stack.push(val);
        }
    }

    public void pop() {
        Integer pop = stack.pop();
        if(pop == min_stack.peek()){
            min_stack.pop();
        }
    }

    public int top() {
        Integer peek = stack.peek();
        return peek;
    }

    public int getMin() {
        return min_stack.peek();
    }
}
