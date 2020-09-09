package Algorithm.LeetCode.LeetCode_125_Valid_Palindrome;

public class Solution_TwoPointer_MyOwn {
    public boolean isPalindrome(String s) {
        int len = s.length();

        if (len <= 1) {
            return true;
        }

        int i = 0, j = len - 1;

        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }

            i++;
            j--;

        }

        return true;
    }

    public static void main(String[] args) {
        Solution_TwoPointer_MyOwn solution = new Solution_TwoPointer_MyOwn();

        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));

        System.out.println(solution.isPalindrome("race a car"));
    }
}
