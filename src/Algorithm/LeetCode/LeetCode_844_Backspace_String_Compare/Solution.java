package Algorithm.LeetCode.LeetCode_844_Backspace_String_Compare;

import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        return execute(s).equals(execute(t));
    }

    private Stack<Character> execute(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        return stack;
    }
}
