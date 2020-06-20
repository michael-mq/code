package Algorithm.LeetCode.LeetCode_516_LongestPalindromicSubsequence;

public class LongestPalindromicSubsequenceDP_516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if (n <= 1) {
            return n;
        }

        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
            print2DArray(dp);
        }

        return dp[0][n - 1];
    }

    void print2DArray(int[][] array) {
        for (int[] x : array) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

class LongestPalindromicSubsequenceDPMain_516 {
    public static void main(String[] args) {
        LongestPalindromicSubsequenceDP_516 foo = new LongestPalindromicSubsequenceDP_516();

//        System.out.println(foo.longestPalindromeSubseq("bbbab"));
//        System.out.println(foo.longestPalindromeSubseq("cbbd"));
        System.out.println(foo.longestPalindromeSubseq("babcbab"));
    }
}