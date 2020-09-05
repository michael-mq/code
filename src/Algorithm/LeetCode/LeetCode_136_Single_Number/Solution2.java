package Algorithm.LeetCode.LeetCode_136_Single_Number;

import java.util.Arrays;
import java.util.Stack;

public class Solution2 {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        Arrays.sort(nums);

        Stack<Integer> stack = new Stack<>();

        stack.push(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (!stack.isEmpty() && nums[i] == stack.peek()) {
                stack.pop();
            } else {
                stack.push(nums[i]);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Solution2 solution1 = new Solution2();

        long startTime = System.nanoTime();

        System.out.println(solution1.singleNumber(new int[]{2, 2, 1}));
        System.out.println(solution1.singleNumber(new int[]{4, 1, 2, 1, 2}));

        long endTime = System.nanoTime();

        System.out.println(endTime - startTime);
    }
}
