package Algorithm.LeetCode.LeetCode_279_Perfect_Squares;

//https://leetcode.cn/problems/perfect-squares/solutions/17639/hua-jie-suan-fa-279-wan-quan-ping-fang-shu-by-guan/
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
}