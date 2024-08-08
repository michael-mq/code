package Algorithm.LeetCode.LeetCode_115_Distinct_Subsequences;

class Solution_DFS_MEMO {
    public int numDistinct(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();

        if (len1 < len2) {
            return 0;
        }

        int[][] memo = new int[len1][len2];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                memo[i][j] = -1;
            }
        }

        return dfs(s, t, len1 - 1, len2 - 1, memo);
    }

    private int dfs(String s, String t, int i, int j, int[][] memo) {
        if (j < 0) {
            return 1;
        }

        if (i < 0) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }


        if (s.charAt(i) == t.charAt(j)) {
            return memo[i][j] = dfs(s, t, i - 1, j - 1, memo) + dfs(s, t, i - 1, j, memo);
        }

        return memo[i][j] = dfs(s, t, i - 1, j, memo);
    }
}