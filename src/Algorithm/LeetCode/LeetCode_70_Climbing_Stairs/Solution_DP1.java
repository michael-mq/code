package Algorithm.LeetCode.LeetCode_70_Climbing_Stairs;

public class Solution_DP1 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution_DP1 foo = new Solution_DP1();

        System.out.println(foo.climbStairs(2));
        System.out.println(foo.climbStairs(3));
    }
}
