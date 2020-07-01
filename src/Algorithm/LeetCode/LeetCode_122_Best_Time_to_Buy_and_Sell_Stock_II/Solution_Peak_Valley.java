package Algorithm.LeetCode.LeetCode_122_Best_Time_to_Buy_and_Sell_Stock_II;

public class Solution_Peak_Valley {
    public int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;

        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i + 1] <= prices[i]) {
                i++;
            }
            valley = prices[i];

            while (i < prices.length - 1 && prices[i + 1] >= prices[i]) {
                i++;
            }
            peak = prices[i];

            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        Solution_Peak_Valley foo = new Solution_Peak_Valley();

        System.out.println(foo.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(foo.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(foo.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
