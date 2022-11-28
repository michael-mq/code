package Algorithm.LeetCode.CN.Interview_03_01;

import java.util.Arrays;

class TripleInOne_MyOwn {
    private Integer[] stack;
    private int stackSize;

    public TripleInOne_MyOwn(int stackSize) {
        this.stackSize = stackSize;
        stack = new Integer[3 * stackSize];
        Arrays.fill(stack, null);
    }

    public void push(int stackNum, int value) {
        for (int i = stackNum * stackSize; i < (stackNum + 1) * stackSize; i++) {
            if (stack[i] == null) {
                stack[i] = value;
            }
        }
    }

    public int pop(int stackNum) {
        for (int i = (stackNum + 1) * stackSize - 1; i >= stackNum * stackSize; i--) {
            if (stack[i] != null) {
                int value = stack[i];
                stack[i] = null;
                return value;
            }
        }

        return -1;
    }

    public int peek(int stackNum) {
        for (int i = (stackNum + 1) * stackSize - 1; i >= stackNum * stackSize; i--) {
            if (stack[i] != null) {
                return stack[i];
            }
        }

        return -1;
    }

    public boolean isEmpty(int stackNum) {
        for (int i = (stackNum + 1) * stackSize - 1; i >= stackNum * stackSize; i--) {
            if (stack[i] != null) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        TripleInOne_MyOwn solution = new TripleInOne_MyOwn(2);

        solution.push(0,1);
        solution.push(0,2);
        solution.push(0,3);

        solution.pop(0);
        solution.pop(0);
        solution.pop(0);

        solution.peek(0);
    }
}