package Algorithm.LeetCode.LeetCode_150_Evaluate_Reverse_Polish_Notation;

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            switch (s) {
                case "+": {
                    int a = stack.pop();
                    int b = stack.pop();

                    stack.push(b + a);
                    break;
                }
                case "-": {
                    int a = stack.pop();
                    int b = stack.pop();

                    stack.push(b - a);
                    break;
                }
                case "*": {
                    int a = stack.pop();
                    int b = stack.pop();

                    stack.push(b * a);
                    break;
                }
                case "/": {
                    int a = stack.pop();
                    int b = stack.pop();

                    stack.push(b / a);
                    break;
                }
                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
}
