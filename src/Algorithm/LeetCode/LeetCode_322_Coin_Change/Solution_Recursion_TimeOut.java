package Algorithm.LeetCode.LeetCode_322_Coin_Change;

class Solution_Recursion_TimeOut {
    private int res = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        helper(coins, amount, 0);

        return res == Integer.MAX_VALUE ?
                -1 : res;
    }

    private void helper(int[] coins, int amount, int count) {
        if (amount < 0) {
            return;
        }

        if (amount == 0) {
            res = Math.min(res, count);
        }

        for (int i = 0; i < coins.length; i++) {
            helper(coins, amount - coins[i], count + 1);
        }
    }
}