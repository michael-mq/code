package Algorithm.LeetCode.LeetCode_28_Str_Str;

public class Solution_Fastest {
    public int strStr(String haystack, String needle) {
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
        Solution_Fastest solutionBruceForce1 = new Solution_Fastest();

        System.out.println(solutionBruceForce1.strStr("hello", "ll"));
        System.out.println(solutionBruceForce1.strStr("aaaaa", "bba"));
        System.out.println(solutionBruceForce1.strStr("source", "target"));
        System.out.println(solutionBruceForce1.strStr("abcdabcdefg", "bcd"));
        System.out.println(solutionBruceForce1.strStr("", ""));
        System.out.println(solutionBruceForce1.strStr("a", "a"));
    }
}
