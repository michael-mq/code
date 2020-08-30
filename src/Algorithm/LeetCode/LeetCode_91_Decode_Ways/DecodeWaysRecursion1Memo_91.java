package Algorithm.LeetCode.LeetCode_91_Decode_Ways;//https://leetcode-cn.com/problems/decode-ways/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-2-3/

import java.util.HashMap;

class DecodeWaysRecursion1Memo {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;

        HashMap<Integer, Integer> memorization = new HashMap<>();
        char[] chars = s.toCharArray();
        return decode(chars, chars.length - 1, memorization);
    }

    public int decode(char[] chars, int index, HashMap<Integer, Integer> memorization) {
        if (index <= 0) return 1;

        int m = memorization.getOrDefault(index, -1);
        if (m != -1) {
            return m;
        }

        int ans1 = 0, ans2 = 0;

        char curr = chars[index];
        char prev = chars[index - 1];

        if (curr > '0') {
            ans1 = decode(chars, index - 1, memorization);
        }

        if (prev == '1' || (prev == '2' && curr <= '6')) {
            ans2 = decode(chars, index - 2, memorization);
        }

        memorization.put(index, ans1 + ans2);
        return ans1 + ans2;
    }
}

class DecodeWaysRecursion1MemoMain {
    public static void main(String[] args) {
        DecodeWaysRecursion1Memo decodeWays = new DecodeWaysRecursion1Memo();

        System.out.println(decodeWays.numDecodings("226"));
    }
}
