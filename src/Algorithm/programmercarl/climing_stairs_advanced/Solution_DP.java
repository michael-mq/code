package Algorithm.programmercarl.climing_stairs_advanced;

public class Solution_DP {
    public int climbStairs(int m, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j >= i) {
                    dp[j] += dp[j - i];
                }
            }
        }

        return dp[n];
    }
}
