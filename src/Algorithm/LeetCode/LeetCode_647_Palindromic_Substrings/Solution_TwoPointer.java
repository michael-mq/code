package Algorithm.LeetCode.LeetCode_647_Palindromic_Substrings;

class Solution_TwoPointer {
    public int countSubstrings(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            result += extend(s, i, i);
            result += extend(s, i, i + 1);
        }

        return result;
    }

    private int extend(String s, int i, int j) {
        int count = 0;

        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            count++;
        }

        return count;
    }
}
