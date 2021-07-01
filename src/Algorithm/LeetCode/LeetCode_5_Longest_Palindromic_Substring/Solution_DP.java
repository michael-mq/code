package Algorithm.LeetCode.LeetCode_5_Longest_Palindromic_Substring;

public class Solution_DP {
    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }

        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        Solution_DP solution_dp = new Solution_DP();

//        System.out.println(solution_dp.longestPalindrome("babad"));
//        System.out.println(solution_dp.longestPalindrome("cbbd"));
        System.out.println(solution_dp.longestPalindrome("aaaa"));
    }
}
