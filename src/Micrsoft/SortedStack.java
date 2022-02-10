package Micrsoft;

import java.util.Stack;

/**
 * @author Steven0516
 * @create 2022-02-09
 */
public class SortedStack {

    Stack<Integer> main;
    Stack<Integer> min;

    public SortedStack() {
        main = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        if (main.isEmpty()){
            main.push(val);
        }else{
            while(!main.isEmpty() && val > main.peek()){
                min.push(main.pop());
            }
            main.push(val);
            while(!min.isEmpty()){
                main.push(min.pop());
            }
        }
    }

    public void pop() {
        main.pop();
    }

    public int peek() {
        if(main.isEmpty()){
            return -1;
        }
        return main.peek();
    }

    public boolean isEmpty() {
        return main.isEmpty();
    }
}
