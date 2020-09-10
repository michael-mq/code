package Algorithm.LeetCode.LeetCode_680_Valid_Palindrome_II;

public class Solution_TwoPointer_MyOwn {
    public boolean validPalindrome(String s) {
        int len = s.length();

        if (len <= 1) {
            return true;
        }

        int i = 0, j = len - 1;

        boolean firstDifference = false;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                firstDifference = true;
                break;
            }

            i++;
            j--;
        }

        if (firstDifference) {
            boolean secondDifference = false;

            int left = i + 1;
            int right = j;
            while (left < right) {

                if (s.charAt(left) != s.charAt(right)) {
                    secondDifference = true;
                }

                left++;
                right--;
            }

            if (secondDifference) {
                left = i;
                right = j - 1;
                while (left < right) {
                    if (s.charAt(left) != s.charAt(right)) {
                        return false;
                    }

                    left++;
                    right--;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_TwoPointer_MyOwn solutionTwoPointerMyOwn = new Solution_TwoPointer_MyOwn();

        System.out.println(solutionTwoPointerMyOwn.validPalindrome("aba"));
        System.out.println(solutionTwoPointerMyOwn.validPalindrome("abca"));
        System.out.println(solutionTwoPointerMyOwn.validPalindrome("deee"));
        System.out.println(solutionTwoPointerMyOwn.validPalindrome("eeccccbebaeeabebccceea"));
        System.out.println(solutionTwoPointerMyOwn.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }


}
