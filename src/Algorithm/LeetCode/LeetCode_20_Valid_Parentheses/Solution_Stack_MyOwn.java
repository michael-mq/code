package Algorithm.LeetCode.LeetCode_20_Valid_Parentheses;

import java.util.Stack;

class Solution_Stack_MyOwn {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }

            if (c == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }

            if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }

            stack.push(c);
        }

        return stack.isEmpty();
    }
}
