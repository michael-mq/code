package Algorithm.LeetCode.LeetCode_227_Basic_Calculator_II;

import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char preSign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }

            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }

                preSign = c;
                num = 0;
            }

        }

        int res = 0;

        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }
}
