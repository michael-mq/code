package Algorithm.LeetCode.LeetCode_1027_Longest_Arithmetic_Subsequence;

class Solution {
    public int longestArithSeqLength(int[] A) {
        if (A == null || A.length < 3)
            return 0;

        int[][] dp = new int[A.length][20001];
        int max = 0;

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                int distance = A[i] - A[j] + 10000;

                if (dp[j][distance] > 0) {
                    dp[i][distance] = Math.max(dp[i][distance], dp[j][distance] + 1);
                } else {
                    dp[i][distance] = 2;
                }

                max = Math.max(max, dp[i][distance]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution foo = new Solution();

        System.out.println(foo.longestArithSeqLength(new int[]{2, 4, 6, 9, 4}));
        System.out.println(foo.longestArithSeqLength(new int[]{2, 4, 6, 9, 8}));
    }
}
