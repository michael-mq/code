package Algorithm.LeetCode.LeetCode_772_Basic_Calculator_III;

import java.util.Stack;

public class Solution_1 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if (c == '(') {
                int count = 1;
                int j = i;

                while (count > 0) {
                    char temp = s.charAt(++j);

                    if (temp == '(') {
                        count++;
                    } else if (temp == ')') {
                        count--;
                    }
                }

                num = calculate(s.substring(i + 1, j));
                i = j;
            }

            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                }

                if (sign == '-') {
                    stack.push(-num);
                }

                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }

                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }

                sign = c;
                num = 0;
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();

//        System.out.println(solution.calculate("1+1"));
//        System.out.println(solution.calculate("2*(5+5*2)/3+(6/2+8)"));
        System.out.println(solution.calculate("30"));
    }
}
