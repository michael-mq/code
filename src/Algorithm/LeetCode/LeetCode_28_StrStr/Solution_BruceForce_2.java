package Algorithm.LeetCode.LeetCode_28_StrStr;

public class Solution_BruceForce_2 {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }

        int haystackLen = haystack.length();
        int needleLen = needle.length();

        if (needleLen == 0) {
            return 0;
        }

        if (haystackLen < needleLen) {
            return -1;
        }

        for (int i = 0; i <= haystackLen - needleLen; i++) {
            int k = i;
            boolean found = true;

            for (int j = 0; j < needleLen; j++) {
                if (haystack.charAt(k) != needle.charAt(j)) {
                    found = false;
                }

                k++;
            }

            if (found){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution_BruceForce_2 solutionBruceForce2 = new Solution_BruceForce_2();

        System.out.println(solutionBruceForce2.strStr("hello", "ll"));
        System.out.println(solutionBruceForce2.strStr("aaaaa", "bba"));
        System.out.println(solutionBruceForce2.strStr("source", "target"));
        System.out.println(solutionBruceForce2.strStr("abcdabcdefg", "bcd"));
        System.out.println(solutionBruceForce2.strStr("", ""));
        System.out.println(solutionBruceForce2.strStr("a", "a"));
    }
}
