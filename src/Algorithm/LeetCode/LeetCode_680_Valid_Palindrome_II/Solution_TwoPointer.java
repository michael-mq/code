package Algorithm.LeetCode.LeetCode_680_Valid_Palindrome_II;

public class Solution_TwoPointer {
    public boolean validPalindrome(String s) {
        int len = s.length();

        if (len <= 1) {
            return true;
        }

        int low = 0;
        int high = len - 1;

        while (low < high) {
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                boolean flag1 = true;
                boolean flag2 = true;

                for (int i = low, j = high - 1; i < j; i++, j--) {
                    if (s.charAt(i) != s.charAt(j)) {
                        flag1 = false;
                        break;
                    }
                }

                for (int i = low + 1, j = high; i < j; i++, j--) {
                    if (s.charAt(i) != s.charAt(j)) {
                        flag2 = false;
                        break;
                    }
                }

                return flag1 || flag2;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_TwoPointer solutionTwoPointerMyOwn = new Solution_TwoPointer();

        System.out.println(solutionTwoPointerMyOwn.validPalindrome("aba"));
        System.out.println(solutionTwoPointerMyOwn.validPalindrome("abca"));
        System.out.println(solutionTwoPointerMyOwn.validPalindrome("deee"));
        System.out.println(solutionTwoPointerMyOwn.validPalindrome("eeccccbebaeeabebccceea"));
        System.out.println(solutionTwoPointerMyOwn.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }


}
