package Algorithm.LeetCode.LeetCode_155_Min_Stack;

import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;


    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else if (minStack.peek() >= x) {
            minStack.push(x);
        }

        stack.push(x);
    }

    public void pop() {
        // IMPORTANT: Do not use `stack.peek() == minStack.peek()`, it will return false when both are -1024
        // alternatively you can do:

        // int foo = stack.peek();
        // int bar = minStack.peek();
        // if (foo == bar) {
        // or
        // if (stack.peek().equals(minStack.peek())) {
        if (stack.peek().equals(minStack.peek())) {
            stack.pop();
            minStack.pop();
        } else {
            stack.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
    }
}
