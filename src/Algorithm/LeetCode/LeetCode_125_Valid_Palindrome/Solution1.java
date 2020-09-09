package Algorithm.LeetCode.LeetCode_125_Valid_Palindrome;

public class Solution1 {
    public boolean isPalindrome(String s) {
        int len = s.length();

        if (len <= 1) {
            return true;
        }

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < len; i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                str.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        StringBuilder strReverse = new StringBuilder(str).reverse();

        return strReverse.toString().equals(str.toString());
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));

        System.out.println(solution.isPalindrome("race a car"));
    }
}
