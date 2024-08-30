package Algorithm.LeetCode.LeetCode_132_Palindrome_Partitioning_II;

//https://leetcode.cn/problems/palindrome-partitioning-ii/solutions/54276/dong-tai-gui-hua-by-liweiwei1419-2/
class Solution {
    public int minCut(String s) {
        int length = s.length();

        if (length == 1) {
            return 0;
        }

        int[] dp = new int[length];

        for (int i = 0; i < length; i++) {
            dp[i] = i;
        }

        boolean[][] isPalindrome = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                        (i - j <= 2 || isPalindrome[j + 1][i - 1])) {
                    isPalindrome[j][i] = true;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0;
                continue;
            }


            for (int j = 0; j < i; j++) {
                if (isPalindrome[j + 1][i]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[length - 1];
    }
}