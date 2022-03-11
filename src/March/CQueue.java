package March;

import java.util.Stack;

/**
 * @author Steven0516
 * @create 2022-03-11
 */
public class CQueue {
    Stack<Integer> first;
    Stack<Integer> second;

    public CQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void appendTail(int value) {
        while(!second.isEmpty()){
            first.add(second.pop());
        }
        first.add(value);
    }

    public int deleteHead() {
        if(first.isEmpty() && second.isEmpty()){
            return -1;
        }else{
            while(!first.isEmpty()){
                second.add(first.pop());
            }
            return second.pop();
        }
    }
}
