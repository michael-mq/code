package Algorithm.LeetCode.LeetCode_496_Next_Greater_Element_I;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://www.programmercarl.com/0496.下一个更大元素I.html
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
            result[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < nums2.length; i++) {
            while (stack.size() != 0 && nums2[stack.peek()] < nums2[i]) {
                if (map.containsKey(stack.peek())) {
                    int index = map.get(stack.peek());
                    result[index] = nums2[i];
                }

                stack.pop();
            }

            stack.push(i);
        }

        return result;
    }
}