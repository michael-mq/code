package Algorithm.LeetCode.LeetCode_1048_Longest_String_Chain;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.cn/problems/longest-string-chain/solution/leetcodebi-ji-java-py-si-ke-yi-dao-ti-1048-zui-cha/

class Solution_2 {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int n = words.length;
        int[] dp = new int[n];
        int res = 0;

        for (int i = 0; i < n; i++) {
            String current = words[i];

            for (int j = i + 1; j < n; j++) {
                String next = words[j];

                if (isPredecessor(current, next)) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }

            res = Math.max(res, dp[i]);
        }

        return res + 1;
    }

    private boolean isPredecessor(String a, String b) {
        int m = a.length();
        int n = b.length();

        if (m + 1 != n) {
            return false;
        }

        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }

            j++;
        }

        return i == m;
    }
}