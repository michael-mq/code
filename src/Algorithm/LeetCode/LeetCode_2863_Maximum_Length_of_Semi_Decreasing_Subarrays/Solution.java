package Algorithm.LeetCode.LeetCode_2863_Maximum_Length_of_Semi_Decreasing_Subarrays;//https://leetcode.com/problems/maximum-length-of-semi-decreasing-subarrays/solutions/4070047/linear-time-solution-in-c-java-python/comments/2177905

// https://www.youtube.com/watch?v=m2zFaH8Ws-o (Opposite direction)

// [57,55,50,60,61,58,63,59,64,60,63]
// [  ,  ,  ,  ,61,  ,63,  ,64,  ,  ] in the stack


import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int maxSubarrayLength(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty() || nums[i] < nums[stack.peek()]) {
                stack.push(i);
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int j = stack.pop();
                max = Math.max(max, j - i + 1);
            }
        }
        
        return max;
    }
}