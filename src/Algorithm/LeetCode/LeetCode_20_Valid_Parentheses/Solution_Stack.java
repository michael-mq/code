package Algorithm.LeetCode.LeetCode_20_Valid_Parentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution_Stack {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && map.get(c) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution_Stack foo = new Solution_Stack();

        System.out.println(foo.isValid("()"));
        System.out.println(foo.isValid("()[]{}"));
        System.out.println(foo.isValid("(]"));
        System.out.println(foo.isValid("([)]"));
        System.out.println(foo.isValid("{[]}"));
    }
}
