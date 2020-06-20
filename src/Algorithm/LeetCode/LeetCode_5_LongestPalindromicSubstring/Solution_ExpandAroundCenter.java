package Algorithm.LeetCode.LeetCode_5_LongestPalindromicSubstring;

public class Solution_ExpandAroundCenter {
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

        for (int i = 0; i < len - 1; i++) {
            int oddLen = expandAroundCenter(s, i, i);
            int evenLen = expandAroundCenter(s, i, i + 1);

            int currentLen = Math.max(oddLen, evenLen);

            if (currentLen > maxLen) {
                maxLen = currentLen;
                begin = i - (maxLen + 1) / 2 + 1;
            }
        }

        return s.substring(begin, begin + maxLen);

    }

    public int expandAroundCenter(String s, int left, int right) {
        while(left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }

        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        Solution_ExpandAroundCenter solution_expandAroundCenter = new Solution_ExpandAroundCenter();

        System.out.println(solution_expandAroundCenter.longestPalindrome("babad"));
        System.out.println(solution_expandAroundCenter.longestPalindrome("cbbd"));
    }
}
