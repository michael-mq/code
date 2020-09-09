package Algorithm.LeetCode.LeetCode_953_Verifying_an_Alien_Dictionary;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < order.length(); ++i)
            map.put(order.charAt(i), i);

        for (int i = 0; i < words.length - 1; ++i) {
            String word1 = words[i];
            String word2 = words[i + 1];

            boolean isDifferent = false;

            // Find the first difference word1[k] != word2[k].
            for (int k = 0; k < Math.min(word1.length(), word2.length()); ++k) {
                if (word1.charAt(k) != word2.charAt(k)) {
                    // two words start to have difference
                    isDifferent = true;

                    // If they compare badly, it's not sorted.
                    if (map.get(word1.charAt(k)) > map.get(word2.charAt(k))) {
                        return false;
                    }
                    break;
                }
            }

            // If we didn't find a first difference
            if(!isDifferent) {

                // words are like ("app", "apple").
                if (word1.length() > word2.length()) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] words = new String[]{"hello", "leetcode"};
        System.out.println(solution.isAlienSorted(words, "hlabcdefgijkmnopqrstuvwxyz"));

        words = new String[]{"word","world","row"};
        System.out.println(solution.isAlienSorted(words, "worldabcefghijkmnpqstuvxyz"));

        words = new String[]{"apple","app"};
        System.out.println(solution.isAlienSorted(words, "abcdefghijklmnopqrstuvwxyz"));

        words = new String[]{"kuvp","q"};
        System.out.println(solution.isAlienSorted(words, "ngxlkthsjuoqcpavbfdermiywz"));
    }
}
