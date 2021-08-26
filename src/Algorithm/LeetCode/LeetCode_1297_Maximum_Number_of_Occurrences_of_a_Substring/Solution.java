package Algorithm.LeetCode.LeetCode_1297_Maximum_Number_of_Occurrences_of_a_Substring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    private Map<String, Integer> map = new HashMap<>();

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        traverse(s, minSize, maxLetters);

//        首先，题目的maxSize是没有用的，因为maxSize能够达到题目的最优解，minSize一定也能达到，因此只要考虑minSize即可。
//        为什么这么说呢，我们举个例子，假设s="aababcaab"，minSize=2，maxSize=3
//        s = "aababcaab"，minSize = 2，maxSize = 3
//        那么我们通过maxSize算出的解是"aab""aab""aab",出现两次，
//        那么"aab""aab""aab"的子串"aa""aa""aa"一定也出现至少有两次（可能会超过两次）。
//        if (minSize != maxSize) {
//            traverse(s, maxSize, maxLetters);
//        }

        int res = 0;

        for (String key: map.keySet()) {
            res = Math.max(res, map.get(key));
        }

        return res;
    }

    private void traverse(String str, int size, int maxLetters) {
        int i = 0;
        int j = size - 1;

        while (j < str.length()) {
            String subString = str.substring(i, j + 1);

            if (isLessOrEqualMaxLetters(subString, maxLetters)) {
                map.put(subString, map.getOrDefault(subString, 0) + 1);
            }

            i++;
            j++;
        }
    }

    private boolean isLessOrEqualMaxLetters(String str, int maxLetters) {
        Set<Character> set = new HashSet<>();

        for (char c : str.toCharArray()) {
            set.add(c);
        }

        return set.size() <= maxLetters;
    }
}
