package Algorithm.LeetCode.LeetCode_1937_Maximum_Number_of_Points_with_Cost;

// https://leetcode.cn/problems/maximum-number-of-points-with-cost/solution/dp-you-hua-ji-qiao-chai-xiang-qian-hou-z-5vvc/
// https://www.youtube.com/watch?v=AfintyFfMP4&t=897s

class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[][] dp = new long[m][n];

        for (int j = 0; j < n; ++j) {
            dp[0][j] = points[0][j];
        }

        for (int i = 1; i < m; ++i) {
            long ret = dp[i - 1][0] + 0;

            for (int j = 0; j < n; ++j) {
                ret = Math.max(ret, dp[i - 1][j] + j);
                dp[i][j] = points[i][j] - j + ret;
            }

            ret = dp[i - 1][n - 1] - (n - 1);

            for (int j = n - 2; j >= 0; --j) {
                ret = Math.max(ret, dp[i - 1][j] - j);
                dp[i][j] = Math.max(dp[i][j], points[i][j] + j + ret);
            }
        }

        long ans = 0;

        for (int j = 0; j < n; ++j) {
            ans = Math.max(ans, dp[m - 1][j]);
        }

        return ans;
    }
}
