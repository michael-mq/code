package Algorithm.HackerRank.HackRank_Recursion_Fibonacci_Numbers;

public class Solution_Memo {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int[] memo = new int[n];

        return helper(memo, n);
    }

    private static int helper(int[] memo, int n) {
        if (memo[n] != 0) {
            return memo[n];
        }

        if (n <= 1) {
            return n;
        }

        return helper(memo, n - 1) + helper(memo, n - 2);
    }
}
