package Algorithm.LeetCode.LeetCode_42_Trapping_Rain_Water;

import java.util.Stack;

// https://leetcode.cn/problems/trapping-rain-water/solutions/692342/jie-yu-shui-by-leetcode-solution-tuvc/ Solution 2
class Solution_Monotonic_Stack {
    public int trap(int[] height) {
        int n = height.length;
        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();

                if (stack.isEmpty()) {
                    break;
                }

                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];

                ans = currWidth * currHeight;
            }

            stack.push(i);
        }

        return ans;
    }
}