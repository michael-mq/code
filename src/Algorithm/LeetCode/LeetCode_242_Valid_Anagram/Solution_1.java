package Algorithm.LeetCode.LeetCode_242_Valid_Anagram;

import Algorithm.LeetCode.LeetCode_239_Sliding_Window_Maximum.Solution_Deque;

import java.util.Arrays;

public class Solution_1 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();

        Arrays.sort(arrS);
        Arrays.sort(arrT);

        return Arrays.equals(arrS, arrT);
    }

    public static void main(String[] args) {
        Solution_1 foo = new Solution_1();

        System.out.println(foo.isAnagram("anagram", "nagaram"));
        System.out.println(foo.isAnagram("rat", "car"));
    }
}
