package Algorithm.LeetCode.LeetCode_921_Minimum_Add_to_Make_Parentheses_Valid;

import java.util.Stack;

public class Solution_Stack {
    public int minAddToMakeValid(String S) {
        int res = 0;
        Stack<Character> stack = new Stack<>();

        for (Character s : S.toCharArray()) {
            if (s == '(') {
                stack.push(s);
            } else if (!stack.isEmpty()) {
                stack.pop();
            } else { // if stack is empty and s == ')'
                res++;
            }
        }

        return res + stack.size(); // stack.size is how many of '('
    }
}
