package Algorithm.LeetCode.CN.Interview_03_05;

import java.util.Stack;

// https://leetcode.cn/problems/sort-of-stacks-lcci/solutions/142998/java-shuang-zhan-duo-xing-geng-xin-17ms-9938-by-la/
class SortedStack {
    //原始栈
    private final Stack<Integer> bigStack;
    //辅助栈
    private final Stack<Integer> smallStack;

    public SortedStack() {
        bigStack = new Stack<>();
        smallStack = new Stack<>();
    }

    public void push(int val) {
        //比较原始栈和辅助栈顶值，使其满足辅助栈<= val <= 原始栈
        while(!bigStack.isEmpty() && bigStack.peek() < val) {
            smallStack.push(bigStack.pop());
        }

        while(!smallStack.isEmpty() && smallStack.peek() > val) {
            bigStack.push(smallStack.pop());
        }

        bigStack.push(val);
    }

    public void pop() {
        //将辅助栈元素push回原始栈
        while (!smallStack.isEmpty()) {
            bigStack.push(smallStack.pop());
        }
        if (!bigStack.isEmpty())
            bigStack.pop();
    }

    public int peek() {
        //将辅助栈元素push回原始栈
        while (!smallStack.isEmpty()) {
            bigStack.push(smallStack.pop());
        }

        return bigStack.isEmpty() ? -1 : bigStack.peek();
    }

    public boolean isEmpty() {
        return bigStack.isEmpty() && smallStack.isEmpty();
    }
}
