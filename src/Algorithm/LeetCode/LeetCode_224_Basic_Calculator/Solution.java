package Algorithm.LeetCode.LeetCode_224_Basic_Calculator;

import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        int[] i = new int[1];

        return dfs(s, i);
    }

    private int dfs(String s, int[] i) {
        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char op = '+';

        for (; i[0] < s.length(); i[0]++) {
            char ch = s.charAt(i[0]);

            if (ch == '(') {
                i[0]++;
                num = dfs(s, i);
            }

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            if (!Character.isDigit(ch) && ch != ' ' || i[0] == s.length() - 1) {
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

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
