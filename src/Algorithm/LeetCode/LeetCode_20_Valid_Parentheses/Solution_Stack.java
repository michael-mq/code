package Algorithm.LeetCode.LeetCode_20_Valid_Parentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution_Stack {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        Map<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == map.get(s.charAt(i))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
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
