package Algorithm.LeetCode.LeetCode_921_Minimum_Add_to_Make_Parentheses_Valid;

import java.util.Stack;

public class Solution_Stack2 {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();

        for (Character s : S.toCharArray()) {
            if (s == '(') {
                stack.push(s);
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(s);
                }
            }
        }

        return stack.size();
    }
}
