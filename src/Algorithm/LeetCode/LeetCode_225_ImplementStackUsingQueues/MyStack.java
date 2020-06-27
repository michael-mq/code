package Algorithm.LeetCode.LeetCode_225_ImplementStackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

public class MyStack {
    private Queue<Integer> q1 = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {
    }

    /** Push element x onto stack. */
    public void push(int x) {
       q1.add(x);

       int count = q1.size();
       while(count-- > 1) {
           q1.add(q1.poll()); // poll() or remove()
       }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.remove();
    }

    /** Get the top element. */
    public int top() {
        return q1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack;

//        stack = new MyStack();
//        stack.push(1);
//        stack.push(2);
//        System.out.println(stack.top());
//        System.out.println(stack.pop());
//        System.out.println(stack.empty());
//        System.out.println(stack.top());
//        System.out.println(stack.pop());
//        System.out.println(stack.empty());

        stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.empty());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}

