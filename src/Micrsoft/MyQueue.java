package Micrsoft;

import java.util.Stack;

/**
 * @author Steven0516
 * @create 2022-02-09
 */
public class MyQueue {

    Stack<Integer> main;
    Stack<Integer> minu;

    /** Initialize your data structure here. */
    public MyQueue() {
        main = new Stack<>();
        minu = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!minu.isEmpty()){
            main.push(minu.peek());
        }
        main.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!main.isEmpty()){
            minu.push(main.pop());
        }
        return minu.pop();
    }

    /** Get the front element. */
    public int peek() {
        while(!main.isEmpty()){
            minu.push(main.pop());
        }
        return minu.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return main.isEmpty() && minu.isEmpty();
    }
}
