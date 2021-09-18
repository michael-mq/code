package Algorithm.LeetCode.LeetCode_5_Longest_Palindromic_Substring;

public class Solution_DP {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        String res = "";
        int start = 0;
        int maxLength = 0;


        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++ ) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;

                    if (j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                        start = i;
                    }

                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        Solution_DP solution_dp = new Solution_DP();

//        System.out.println(solution_dp.longestPalindrome("babad"));
//        System.out.println(solution_dp.longestPalindrome("cbbd"));
        System.out.println(solution_dp.longestPalindrome("aaaa"));
    }
}
