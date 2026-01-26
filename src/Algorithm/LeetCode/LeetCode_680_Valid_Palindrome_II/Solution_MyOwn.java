package Algorithm.LeetCode.LeetCode_680_Valid_Palindrome_II;

class Solution_MyOwn {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        int count = 0;
        boolean ans1 = true;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                count++;

                if (count > 1) {
                    ans1 = false;
                }

                i++;
            } else {
                i++;
                j--;
            }
        }

        i = 0;
        j = s.length() - 1;
        count = 0;
        boolean ans2 = true;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                count++;

                if (count > 1) {
                    ans2 = false;
                }

                j--;
            } else {
                i++;
                j--;
            }
        }

        return ans1 || ans2;
    }
}