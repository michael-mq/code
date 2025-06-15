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
//
//        Even if both values are -1024, the two Integer objects may not be the same object in memory, so:
//        new Integer(-1024) == new Integer(-1024) // false

//        Java caches Integer objects in the range [-128 to 127] as an optimization (called Integer caching). So:
//        Integer a = 100;
//        Integer b = 100;
//        a == b; // true — same cached object
//
//        Integer a = -1024;
//        Integer b = -1024;
//        a == b; // false — different objects


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

        System.out.println(-1024 == -1024);
        System.out.println(Integer.valueOf(-1024) == Integer.valueOf(-1024));
    }
}

