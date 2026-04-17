package Algorithm.LeetCode.LeetCode_953_Verifying_an_Alien_Dictionary;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // Map each character to its rank in the alien alphabet
        int[] charOrder = new int[26];
        for (int i = 0; i < order.length(); i++) {
            charOrder[order.charAt(i) - 'a'] = i;
        }

        // Compare adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(words[i], words[i + 1], charOrder)) {
                return false;
            }
        }

        return true;
    }

    private boolean isSorted(String word1, String word2, int[] charOrder) {
        int len1 = word1.length();
        int len2 = word2.length();
        int minLen = Math.min(len1, len2);

        for (int j = 0; j < minLen; j++) {
            char c1 = word1.charAt(j);
            char c2 = word2.charAt(j);

            // If characters are different, check their relative order
            if (c1 != c2) {
                return charOrder[c1 - 'a'] < charOrder[c2 - 'a'];
            }
        }

        // If we reach here, one word is a prefix of the other.
        // The shorter word must come first.
        return len1 <= len2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] words = new String[]{"hello", "leetcode"};
        System.out.println(solution.isAlienSorted(words, "hlabcdefgijkmnopqrstuvwxyz"));

        words = new String[]{"word", "world", "row"};
        System.out.println(solution.isAlienSorted(words, "worldabcefghijkmnpqstuvxyz"));

        words = new String[]{"apple", "app"};
        System.out.println(solution.isAlienSorted(words, "abcdefghijklmnopqrstuvwxyz"));

        words = new String[]{"kuvp", "q"};
        System.out.println(solution.isAlienSorted(words, "ngxlkthsjuoqcpavbfdermiywz"));
    }
}
