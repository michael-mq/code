package Algorithm.LeetCode.LeetCode_1359_Count_All_Valid_Pickup_and_Delivery_Options;

//https://www.youtube.com/watch?v=H0Yl1AlUuK8
class Solution {
    public int countOrders(int n) {
        final int MOD = 1000000007;
        long res = 1;

        for (int i = 1; i <= n; i++) {
            res *= i * (2L * i - 1);
            res %= MOD;
        }

        return (int) res % MOD;
    }
}
