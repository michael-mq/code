package Algorithm.LeetCode.LeetCode_322_Coin_Change;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];

    }

    public static void main(String[] args) {
        Solution foo = new Solution();

        System.out.println(foo.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(foo.coinChange(new int[]{2}, 3));

    }
}
