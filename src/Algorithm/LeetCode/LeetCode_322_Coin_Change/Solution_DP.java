package Algorithm.LeetCode.LeetCode_322_Coin_Change;

import java.util.Arrays;

// https://leetcode.cn/problems/coin-change/solutions/137661/javadi-gui-ji-yi-hua-sou-suo-dong-tai-gui-hua-by-s/
public class Solution_DP {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution_DP foo = new Solution_DP();

        System.out.println(foo.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(foo.coinChange(new int[]{2}, 3));

    }
}
