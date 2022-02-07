package Micrsoft;

import java.util.Stack;

/**
 * @author Steven0516
 * @create 2022-02-07
 */
public class MinStack {
    Stack<Integer> main;
    Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        main = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        main.push(x);
        if(min.isEmpty() || x < min.peek()){
            min.push(x);
        }else{
            min.push(min.peek());
        }
    }

    public void pop() {
        if(main.isEmpty()){
            return;
        }else{
            main.pop();
            min.pop();
        }
    }

    public int top() {
        return main.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
