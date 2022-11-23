package Algorithm.LeetCode.LeetCode_739_Daily_Temperatures;

import java.util.Stack;

// check LeetCode_503
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        if (n == 1) {
            return result;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int curr = stack.pop();
                result[curr] = i - curr;
            }

            stack.push(i);
        }

        return result;
    }
}