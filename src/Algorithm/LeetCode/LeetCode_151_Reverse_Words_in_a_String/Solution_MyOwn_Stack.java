package Algorithm.LeetCode.LeetCode_151_Reverse_Words_in_a_String;

import java.util.Stack;

class Solution_MyOwn_Stack {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();

        int pointer = 0;

        s = s.trim();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                stack.push(s.substring(pointer, i));
            }

            while (s.charAt(i) == ' ') {
                i++;
                pointer = i;
            }
        }

        stack.push(s.substring(pointer, s.length()));
        int size = stack.size();

        for (int i = 0; i < size; i++) {
            stringBuilder.append(stack.pop());

            if (i != size - 1) {
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution_MyOwn_Stack foo = new Solution_MyOwn_Stack();
        System.out.println(foo.reverseWords("F S "));
    }
}
