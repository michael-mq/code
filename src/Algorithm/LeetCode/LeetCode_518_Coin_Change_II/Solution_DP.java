package Algorithm.LeetCode.LeetCode_518_Coin_Change_II;

//https://www.programmercarl.com/0518.零钱兑换II.html#其他语言版本
class Solution_DP {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int i = 0; i < len; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j] + dp[j - coins[i]];
            }
        }

        return dp[amount];
    }
}