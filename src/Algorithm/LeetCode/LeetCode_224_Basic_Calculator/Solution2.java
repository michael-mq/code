package Algorithm.LeetCode.LeetCode_224_Basic_Calculator;

import java.util.Stack;

public class Solution2 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        // Everytime we see + or - or ( or ), it's the time to do the calculation
        int num = 0;
        int res = 0;
        int sign = 1; // previous sign

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                res += sign * num;
                num = 0;
                sign = c == '+' ? 1 : -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res += sign * num;
                res = stack.pop() * res + stack.pop();
                num = 0;
            }
        }

        res += sign * num;

        return res;
    }
}
