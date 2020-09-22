package Algorithm.LeetCode.LeetCode_1027_Longest_Arithmetic_Subsequence;

import java.util.HashMap;
import java.util.Map;

class Solution_HashMap {
    public int longestArithSeqLength(int[] A) {
        if (A == null || A.length < 2)
            return 0;

        Map<Integer, Integer>[] dp = new HashMap[A.length];

        int max = 2;

        for (int i = 0; i < A.length; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int distance = A[i] - A[j];

                if (dp[j].containsKey(distance)) {
                    dp[i].put(distance,
                            Math.max(dp[i].getOrDefault(distance, 0), dp[j].get(distance) + 1));
                } else {
                    dp[i].put(distance, 2);
                }

                max = Math.max(max, dp[i].get(distance));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution_HashMap foo = new Solution_HashMap();

        System.out.println(foo.longestArithSeqLength(new int[]{2, 4, 6, 9, 4}));
        System.out.println(foo.longestArithSeqLength(new int[]{2, 4, 6, 9, 8}));
    }
}
