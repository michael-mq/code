package Algorithm.LeetCode.LeetCode_121_Best_Time_to_Buy_and_Sell_Stock;

class Solution2 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;

        for (int price : prices) {
            minPrice = Math.min(price, minPrice);
            profit = Math.max(profit, price - minPrice);
        }

        return profit;
    }
}
