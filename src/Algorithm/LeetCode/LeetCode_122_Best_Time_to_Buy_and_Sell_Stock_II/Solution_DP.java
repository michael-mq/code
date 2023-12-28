package Algorithm.LeetCode.LeetCode_122_Best_Time_to_Buy_and_Sell_Stock_II;

//https://www.programmercarl.com/0122.买卖股票的最佳时机II（动态规划）.html
public class Solution_DP {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int length = prices.length;
        // dp[i][0]代表第i天持有股票的最大收益
        // dp[i][1]代表第i天不持有股票的最大收益
        int[][] dp = new int[length][2];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < length; i++) {
            // 继续持有 或者 买了(可以买多次)
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            // 卖了 或者 继续不持有
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return dp[length - 1][1];
    }
}
