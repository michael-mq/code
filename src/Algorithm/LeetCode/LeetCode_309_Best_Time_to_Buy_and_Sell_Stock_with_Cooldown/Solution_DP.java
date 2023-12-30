package Algorithm.LeetCode.LeetCode_309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

//https://www.programmercarl.com/0309.最佳买卖股票时机含冷冻期.html
class Solution_DP {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        // 0, 持有股票
        // 1, 保持不持有股票
        // 2, 卖出股票
        // 3, 冷冻期
        int[][] dp = new int[length][4];
        dp[0][0] = -prices[0];

        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1] - prices[i], dp[i - 1][3] - prices[i]));
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }

        return Math.max(dp[length - 1][1], Math.max(dp[length - 1][2], dp[length - 1][3]));
    }
}