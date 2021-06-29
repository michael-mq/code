package Algorithm.LeetCode.LeetCode_151_Reverse_Words_in_a_String;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution_MyOwn_Deque {
    public String reverseWords(String s) {
        Deque<String> queue = new ArrayDeque<>();
        StringBuilder stringBuilder = new StringBuilder();

        int pointer = 0;

        s = s.trim();

        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length()) {
                queue.offerFirst(s.substring(pointer, i));
                break;
            } else if (s.charAt(i) == ' ') {
                queue.offerFirst(s.substring(pointer, i));
            }

            while (s.charAt(i) == ' ') {
                i++;
                pointer = i;
            }
        }

        return String.join(" ", queue);
    }

    public static void main(String[] args) {
        Solution_MyOwn_Deque foo = new Solution_MyOwn_Deque();
        System.out.println(foo.reverseWords("F S "));
    }
}
