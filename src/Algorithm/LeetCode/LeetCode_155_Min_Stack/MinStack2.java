package Algorithm.LeetCode.LeetCode_155_Min_Stack;

import java.util.Stack;

class MinStack2 {
    private Stack<Integer> stack;
    private int min;

    public MinStack2() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        stack.push(val);
        min = Math.min(min, val);
    }

    public void pop() {
        int val = stack.pop();

        if (val <= min) {
            min = Integer.MAX_VALUE;

            for (int n : stack) {
                min = Math.min(min, n);
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}


