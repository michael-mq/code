package Algorithm.LeetCode.LeetCode_221_Maximal_Square;

// Using this one https://leetcode.cn/problems/maximal-square/solutions/44586/li-jie-san-zhe-qu-zui-xiao-1-by-lzhlyle/?orderBy=most_votes
class Solution_DP1 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i][j]), dp[i + 1][j]) + 1;
                    res = Math.max(res, dp[i + 1][j + 1]);
                }

            }
        }

        return res * res;
    }
}