package Algorithm.LeetCode.LeetCode_70_Climbing_Stairs;

class Solution_Memo {
    public int climbStairs(int n) {
        return helper(n, new int[n + 1]);
    }

    private int helper(int n, int[] memo) {
        if (n <= 2) {
            memo[n] = n;
        }

        if (memo[n] == 0) {
            memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
        }
        
        return memo[n];
    }
}