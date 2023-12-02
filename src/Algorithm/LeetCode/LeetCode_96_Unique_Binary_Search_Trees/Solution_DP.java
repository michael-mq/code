package Algorithm.LeetCode.LeetCode_96_Unique_Binary_Search_Trees;

//https://www.programmercarl.com/0096.不同的二叉搜索树.html
class Solution_DP {
    int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
