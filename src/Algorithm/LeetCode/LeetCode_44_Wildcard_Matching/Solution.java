package Algorithm.LeetCode.LeetCode_44_Wildcard_Matching;

//https://leetcode.cn/problems/wildcard-matching/solutions/316462/yi-ge-qi-pan-kan-dong-dong-tai-gui-hua-dpsi-lu-by-/
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];

        dp[0][0] = true;

        for (int i = 1; i <= p.length(); i++) {
            dp[i][0] = dp[i - 1][0] && p.charAt(i - 1) == '*';
        }

        for (int i = 1; i <= p.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (p.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[p.length()][s.length()];
    }
}