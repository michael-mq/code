package Algorithm.LeetCode.LeetCode_1048_Longest_String_Chain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=pXG3uE_KqZM

class Solution_1 {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> memo = new HashMap<>();
        int res = 0;

        for (String word : words) {
            memo.put(word, 1);

            for (int i = 0; i < word.length(); i++) {
                StringBuilder current = new StringBuilder(word);
                String previous = current.deleteCharAt(i).toString();

                if (memo.containsKey(previous)) {
                    memo.put(word, Math.max(memo.get(word), memo.get(previous) + 1));
                }
            }

            res = Math.max(res, memo.get(word));
        }

        return res;
    }
}