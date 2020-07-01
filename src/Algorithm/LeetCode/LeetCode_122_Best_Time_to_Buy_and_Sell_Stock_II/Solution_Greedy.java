package Algorithm.LeetCode.LeetCode_122_Best_Time_to_Buy_and_Sell_Stock_II;

public class Solution_Greedy {
    public int maxProfit(int[] prices) {
        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution_Greedy foo = new Solution_Greedy();

        System.out.println(foo.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(foo.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(foo.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
