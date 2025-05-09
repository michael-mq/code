package Algorithm.LeetCode.LeetCode_394_Decode_String;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class Solution_Stack {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                Deque<Character> decodedString = new LinkedList<>();

                while (stack.peek() != '[') {
                    decodedString.addFirst(stack.pop());
                }

                stack.pop();

                int base = 1;
                int num = 0;

                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    num += (stack.pop() - '0') * base;
                    base *= 10;
                }

                for (int j = 0; j < num; j++) {
                    for (char c : decodedString) {
                        stack.push(c);
                    }
                }

            } else {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}