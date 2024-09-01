package Algorithm.LeetCode.LeetCode_96_Unique_Binary_Search_Trees;

class Solution_Recursive_Memo {
    public int numTrees(int n) {
        int[] memo = new int[n + 1];

        return count(n, memo);
    }

    private int count(int n, int[] memo) {
        if (memo[n] != 0) {
            return memo[n];
        }

        if (n <= 1) {
            return 1;
        }

        int res = 0;

        for (int i = 1; i <= n; i++) {
            res += count(i - 1, memo) * count(n - i, memo);
        }

        memo[n] = res;

        return res;
    }
}
