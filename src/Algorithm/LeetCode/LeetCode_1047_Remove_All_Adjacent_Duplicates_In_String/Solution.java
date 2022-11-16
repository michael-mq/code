package Algorithm.LeetCode.LeetCode_1047_Remove_All_Adjacent_Duplicates_In_String;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.empty() || stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        char[] result = new char[stack.size()];

        int i = 0;
        for (char c : stack) {
            result[i++] = c;
        }

        return String.valueOf(result);
    }
}