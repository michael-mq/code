package Algorithm.LeetCode.LeetCode_28_Str_Str;

public class Solution_BruceForce_1 {
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

        for (int i = 0; i < haystackLen; i++) {
            if (i + needleLen <= haystackLen && haystack.substring(i, i + needleLen).equals(needle)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution_BruceForce_1 solutionBruceForce1 = new Solution_BruceForce_1();

        System.out.println(solutionBruceForce1.strStr("hello", "ll"));
        System.out.println(solutionBruceForce1.strStr("aaaaa", "bba"));
        System.out.println(solutionBruceForce1.strStr("source", "target"));
        System.out.println(solutionBruceForce1.strStr("abcdabcdefg", "bcd"));
        System.out.println(solutionBruceForce1.strStr("", ""));
        System.out.println(solutionBruceForce1.strStr("a", "a"));
    }
}
