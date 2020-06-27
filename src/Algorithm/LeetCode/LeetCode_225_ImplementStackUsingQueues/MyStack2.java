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

public class MyStack2 {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private int top;

    /**
     * Initialize your data structure here.
     */
    public MyStack2() {
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        top = x;
        q1.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (q1.size() == 0) {
            while (q2.size() > 1) {
                top = q2.peek();
                q1.add(q2.remove());
            }
            return q2.remove();
        }

        while (q1.size() > 1) {
            top = q1.peek();
            q2.add(q1.remove());
        }

        return q1.remove();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return top;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q1.size() == 0 && q2.size() == 0;
    }

    public static void main(String[] args) {
        MyStack2 stack;

//        stack = new MyStack();
//        stack.push(1);
//        stack.push(2);
//        System.out.println(stack.top());
//        System.out.println(stack.pop());
//        System.out.println(stack.empty());
//        System.out.println(stack.top());
//        System.out.println(stack.pop());
//        System.out.println(stack.empty());

        stack = new MyStack2();
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

