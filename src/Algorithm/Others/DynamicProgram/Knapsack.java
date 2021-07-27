package Algorithm.Others.DynamicProgram;

public class Knapsack {
    int knapsack(int W, int N, int[] wt, int[] val) {
        int[][] dp = new int[N + 1][W + 1];

        for (int i = 0; i <= W; i++) {
            dp[0][i] = 0;
        }

        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < W; j++) {
                if (W - wt[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][W - wt[i - 1]] + val[i - 1],
                            dp[i - 1][j]
                    );
                }
            }
        }

        return dp[N][W];
    }
}
