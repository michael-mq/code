package Algorithm.LeetCode.LeetCode_122_Best_Time_to_Buy_and_Sell_Stock_II;

public class Solution_Peak_Valley_My_Own {
    public int maxProfit(int[] prices) {
        int buyIndex = -1, sellIndex = -1, money = 0;

        for (int i = 0; i < prices.length; i++) {
            // as long as it finds a valley, mark it as a buying point
            if (buyIndex == -1 && i < prices.length - 1 && prices[i] < prices[i + 1]) {
                buyIndex = i;
                continue;
            }
            // if there is a valley already, as long as it finds a peak, mark it as a selling point. Then reset buying point
            if (buyIndex != -1 && (i < prices.length - 1 && prices[i] > prices[i + 1] || i == prices.length - 1 && prices[i] > prices[buyIndex])) {
                sellIndex = i;
                money += prices[sellIndex] - prices[buyIndex];
                buyIndex = -1;
                continue;
            }
        }
        return money;
    }

    public static void main(String[] args) {
        Solution_Peak_Valley_My_Own foo = new Solution_Peak_Valley_My_Own();

        System.out.println(foo.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(foo.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(foo.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
