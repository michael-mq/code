package Algorithm.LeetCode.LeetCode_581_Shortest_Unsorted_Continuous_Subarray;

import java.util.Stack;

public class Solution_Stack {
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        int start = nums.length, end = 0;

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                start = Math.min(start, stack.pop());
            }
            stack.push(i);
        }

        stack.clear();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                end = Math.max(end, stack.pop());
            }
            stack.push(i);
        }

        return end - start > 0 ? end - start + 1 : 0;
    }

    public static void main(String[] args) {
        Solution_Stack solutionSorting = new Solution_Stack();

        System.out.println(solutionSorting.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }
}
