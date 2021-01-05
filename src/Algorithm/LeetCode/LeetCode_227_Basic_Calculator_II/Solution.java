package Algorithm.LeetCode.LeetCode_227_Basic_Calculator_II;

import java.util.Stack;

public class Solution {
    private int i = 0;

    public int calculate(String s) {
        return dfs(s, i);
    }

    private int dfs(String s, int i) {
        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char op = '+';

        for (; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                i++;
                num = dfs(s, i);
            }

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            if (!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1) {
                switch (op) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        int pre = stack.pop();
                        stack.push(pre * num);
                        break;
                    case '/':
                        pre = stack.pop();
                        stack.push(pre / num);
                        break;
                }

                num = 0;
                op = ch;
            }

            if (ch == ')') {
                break;
            }
        }

        int res = 0;

        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }
}
