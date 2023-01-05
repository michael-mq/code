package Algorithm.LeetCode.CN.Interview_16_26;

import java.util.Stack;

class Solution {
    public int calculate(String s) {
        char preSign = '+';
        int num = 0;
        int n = s.length();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if (!Character.isDigit(c) && c != ' ' || i == n - 1) {
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

        int ans = 0;

        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;
    }
}