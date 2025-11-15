package Algorithm.LeetCode.LeetCode_5_Longest_Palindromic_Substring;

public class Solution_ExpandAroundCenter {
    public String longestPalindrome(String s) {
        int maxLen = 1;
        int begin = 0;

        for (int i = 0; i < s.length(); i++) {
            int oddLen = expandAroundCenter(s, i, i);
            int evenLen = expandAroundCenter(s, i, i + 1);

            int currentLen = Math.max(oddLen, evenLen);

            if (currentLen > maxLen) {
                maxLen = currentLen;
                begin = i - (maxLen + 1) / 2 + 1;
//                begin = i - (maxLen - 1) / 2;
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1; // right - left + 1 - 2
    }

    public static void main(String[] args) {
        Solution_ExpandAroundCenter solution_expandAroundCenter = new Solution_ExpandAroundCenter();

        System.out.println(solution_expandAroundCenter.longestPalindrome("babad"));
        System.out.println(solution_expandAroundCenter.longestPalindrome("cbbd"));
    }
}
