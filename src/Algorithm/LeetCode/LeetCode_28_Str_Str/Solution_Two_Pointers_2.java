package Algorithm.LeetCode.LeetCode_28_Str_Str;

public class Solution_Two_Pointers_2 {
    public int strStr(String haystack, String needle) {
        int haystackLen = haystack.length();
        int needleLen = needle.length();

        if (needleLen == 0) {
            return 0;
        }

        if (haystackLen < needleLen) {
            return -1;
        }

        int haystackPointer = 0;
        while (haystackPointer < haystackLen - needleLen + 1) {
            // find the position of the first needle character
            // in the haystack string
            while (haystackPointer < haystackLen - needleLen + 1 && haystack.charAt(haystackPointer) != needle.charAt(0))
                ++haystackPointer;

            // compute the max match string
            int currLen = 0, needlePointer = 0;
            while (needlePointer < needleLen && haystackPointer < haystackLen
                    && haystack.charAt(haystackPointer) == needle.charAt(needlePointer)) {
                haystackPointer++;
                needlePointer++;
                currLen++;
            }

            // if the whole needle string is found,
            // return its start position
            if (currLen == needleLen) return haystackPointer - needleLen;

            // otherwise, backtrack
            haystackPointer = haystackPointer - currLen + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution_Two_Pointers_2 solutionTwoPointer2 = new Solution_Two_Pointers_2();

        System.out.println(solutionTwoPointer2.strStr("hello", "ll"));
        System.out.println(solutionTwoPointer2.strStr("aaaaa", "bba"));
        System.out.println(solutionTwoPointer2.strStr("source", "target"));
        System.out.println(solutionTwoPointer2.strStr("abcdabcdefg", "bcd"));
        System.out.println(solutionTwoPointer2.strStr("", ""));
        System.out.println(solutionTwoPointer2.strStr("a", "a"));
        System.out.println(solutionTwoPointer2.strStr("aaa", "aaa"));
        System.out.println(solutionTwoPointer2.strStr("babba", "bbb"));
    }
}
