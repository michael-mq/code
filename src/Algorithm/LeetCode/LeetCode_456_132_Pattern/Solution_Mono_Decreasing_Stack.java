package Algorithm.LeetCode.LeetCode_456_132_Pattern;

import java.util.Stack;

class Solution_Mono_Decreasing_Stack {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int[] min = new int[nums.length];

        min[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }

        Stack<Integer> stack = new Stack<>();

        for (int j = nums.length - 1; j > 0; j--) {
            if (nums[j] > min[j]) {
                int maxMin = Integer.MIN_VALUE; // if maxMin is MIN_VALUE, it means there is no max minimum for the current number

                while (!stack.isEmpty() && stack.peek() < nums[j]) {
                    maxMin = stack.pop();
                }

                stack.add(nums[j]);

                if (min[j] < maxMin) {
                    return true;
                }
            }
        }

        return false;
    }
}