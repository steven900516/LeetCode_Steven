package Micrsoft;

import java.util.Stack;

/**
 * @author Steven0516
 * @create 2022-02-23
 */
public class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.add(value);
    }

    public int deleteHead() {
        if(stack1.isEmpty()){
            return -1;
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
