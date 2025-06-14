package Algorithm.LeetCode.LeetCode_322_Coin_Change;

import java.util.Arrays;

// https://leetcode.cn/problems/coin-change/solutions/137661/javadi-gui-ji-yi-hua-sou-suo-dong-tai-gui-hua-by-s/
public class Solution_DP2 {
    public int coinChange(int[] coins, int amount) {
        // 自底向上的动态规划
        if (coins.length == 0) {
            return -1;
        }

        // memo[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
        int[] memo = new int[amount + 1];
        memo[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && memo[i - coin] < min) {
                    min = memo[i - coin] + 1;
                }
            }
            // memo[i] = (min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min);
            memo[i] = min;
        }

        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }
}
