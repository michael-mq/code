package Algorithm.LeetCode.LeetCode_844_Backspace_String_Compare;

import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    private String build(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        return String.valueOf(stack);
    }
}