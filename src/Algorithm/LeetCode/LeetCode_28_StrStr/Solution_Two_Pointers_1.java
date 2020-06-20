package Algorithm.LeetCode.LeetCode_28_StrStr;

public class Solution_Two_Pointers_1 {
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

        int haystackPointer = 0;

        while (haystackPointer < haystackLen - needleLen + 1) {
            while (haystackPointer < haystackLen - needleLen + 1 && haystack.charAt(haystackPointer) != needle.charAt(0)) {
                haystackPointer++;
            }

            int needlePointer = 0;
            int pointerLen = 0;

            while (haystackPointer < haystackLen && needlePointer < needleLen) {
                if (haystack.charAt(haystackPointer) != needle.charAt(needlePointer)) {
                    haystackPointer = haystackPointer - needlePointer + 1;
                    needlePointer = 0;
                    pointerLen = 0;
                } else {
                    haystackPointer++;
                    needlePointer++;
                    pointerLen++;
                }
            }

            if (pointerLen == needleLen) {
                return haystackPointer - needleLen;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution_Two_Pointers_1 solutionTwoPointer1 = new Solution_Two_Pointers_1();

        System.out.println(solutionTwoPointer1.strStr("hello", "ll"));
        System.out.println(solutionTwoPointer1.strStr("aaaaa", "bba"));
        System.out.println(solutionTwoPointer1.strStr("source", "target"));
        System.out.println(solutionTwoPointer1.strStr("abcdabcdefg", "bcd"));
        System.out.println(solutionTwoPointer1.strStr("", ""));
        System.out.println(solutionTwoPointer1.strStr("a", "a"));
        System.out.println(solutionTwoPointer1.strStr("aaa", "aaa"));
        System.out.println(solutionTwoPointer1.strStr("babba", "bbb"));
    }
}
