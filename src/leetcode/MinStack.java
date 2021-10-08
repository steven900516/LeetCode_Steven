package leetcode;

import java.util.Stack;

/**
 * @author Steven0516
 * @create 2021-09-07
 */


//力扣30  包含min函数的栈
//    难点：将min函数的时间复杂度降为O(1)
    /*
    数据栈 AA ： 栈 AA 用于存储所有元素，保证入栈 push() 函数、出栈 pop() 函数、获取栈顶 top() 函数的正常逻辑。
    辅助栈 BB ： 栈 BB 中存储栈 AA 中所有 非严格降序 的元素，则栈 AA 中的最小元素始终对应栈 BB 的栈顶元素，即 min() 函数只需返回栈 BB 的栈顶元素即可。

     */
public class MinStack {
    /** initialize your data structure here. */
    Stack<Integer> A, B;
    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }
    public void push(int x) {
        A.add(x);
        if(B.empty() || B.peek() >= x)
            B.add(x);
    }
    public void pop() {
        if(A.pop().equals(B.peek()))
            B.pop();
    }
    public int top() {
        return A.peek();
    }
    public int min() {
        return B.peek();
    }

    public static void main(String[] args) {
        MinStack mineStack = new MinStack();
        mineStack.push(1);
        mineStack.push(0);
        mineStack.push(-5);
        mineStack.push(-3);
        int top = mineStack.top();
        System.out.println(top);
        mineStack.pop();
        System.out.println(mineStack.top());
        System.out.println(mineStack.min());
    }
}
