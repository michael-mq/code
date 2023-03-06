package Algorithm.LeetCode.LeetCode_772_Basic_Calculator_III;

import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int number = 0;
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            }

            if (c == '(') {
                int count = 1;
                int j = i + 1;

                while (count > 0) {
                    if (s.charAt(j) == '(') {
                        count++;
                    } else if (s.charAt(j) == ')') {
                        count--;
                    }

                    j++;
                }

                number = calculate(s.substring(i + 1, j - 1));
                i = j - 1;
            }

            if (c != ' ' && !Character.isDigit(c) || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(number);
                } else if (sign == '-') {
                    stack.push(-number);
                } else if (sign == '*') {
                    stack.push(stack.pop() * number);
                } else if (sign == '/') {
                    stack.push(stack.pop() / number);
                }

                number = 0;
                sign = c;
            }
        }

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}
