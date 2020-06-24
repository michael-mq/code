package Algorithm.LeetCode.LeetCode_20_ValidParentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution_Stack2 {
    public boolean isValid(String s) {
        if(s.length() >1 && s.length() % 2 != 0){
            return false;
        }

        HashMap<Character, Character> mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (mappings.containsKey(c)) {
                // If it's the closing bracket as the first element
                if(stack.empty()){
                    return false;
                }

                // Pop the top element
                char topElement = stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                // Else, let it pop.
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution_Stack2 foo = new Solution_Stack2();

        System.out.println(foo.isValid("()"));
        System.out.println(foo.isValid("()[]{}"));
        System.out.println(foo.isValid("(]"));
        System.out.println(foo.isValid("([)]"));
        System.out.println(foo.isValid("{[]}"));
    }
}
