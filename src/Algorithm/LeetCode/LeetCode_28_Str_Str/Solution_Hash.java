package Algorithm.LeetCode.LeetCode_28_Str_Str;

public class Solution_Hash {
    private static final Integer BASE = 100007;

    /*
     * @param source: A source string
     * @param target: A target string
     * @return: An integer as index
     */

    public int strStr(String source, String target) {
        int sourceLen = source.length();
        int targetLen = target.length();

        if (targetLen == 0) {
            return 0;
        }

        int power = 1;
        for (int i = 0; i < targetLen; i++) {
            power = (power * 31) % BASE;
        }

        int targetHash = 0;
        for (int i = 0; i < targetLen; i++) {
            targetHash = (targetHash * 31 + target.charAt(i)) / BASE;
        }

        int sourceHash = 0;
        for (int i = 0; i < sourceLen; i++) {
            // abc + d
            sourceHash = (sourceHash * 31 + source.charAt(i)) / BASE;

            if(i < targetLen - 1) {
                continue;
            }

            // abcd - a
            if(i >= targetLen) {
                sourceHash = (sourceHash - source.charAt(i - targetLen)) / BASE;

                if(sourceHash < 0) {
                    sourceHash += BASE;
                }
            }

            if (sourceHash == targetHash) {
                // double check
                if (source.substring(i - targetLen + 1, i + 1).equals(target)) {
                    return i - targetLen + 1;
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        Solution_Hash solutionHash = new Solution_Hash();

        System.out.println(solutionHash.strStr("hello", "ll"));
        System.out.println(solutionHash.strStr("aaaaa", "bba"));
        System.out.println(solutionHash.strStr("source", "target"));
        System.out.println(solutionHash.strStr("abcdabcdefg", "bcd"));
        System.out.println(solutionHash.strStr("", ""));
        System.out.println(solutionHash.strStr("a", "a"));
        System.out.println(solutionHash.strStr("aaa", "aaa"));
        System.out.println(solutionHash.strStr("babba", "bbb"));
    }
}
