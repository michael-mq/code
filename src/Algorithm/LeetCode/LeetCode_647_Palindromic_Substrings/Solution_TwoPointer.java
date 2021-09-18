package Algorithm.LeetCode.LeetCode_647_Palindromic_Substrings;

class Solution_TwoPointer {
    public int countSubstrings(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            res += extend(s, i, i);
            res += extend(s, i, i + 1);
        }

        return res;
    }

    private int extend(String s, int i, int j) {
        int res = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            res++;
        }

        return res;
    }
}
