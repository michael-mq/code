package Algorithm.LeetCode.LeetCode_714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee;

//https://www.programmercarl.com/0714.买卖股票的最佳时机含手续费（动态规划）.html
class Solution_DP {
    public int maxProfit(int[] prices, int fee) {
        int length = prices.length;

        int[][] dp = new int[length][2];

        dp[0][0] = -prices[0];

        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }

        return dp[length - 1][1];
    }
}