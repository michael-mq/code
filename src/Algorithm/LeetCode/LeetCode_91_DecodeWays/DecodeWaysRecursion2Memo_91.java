package Algorithm.LeetCode.LeetCode_91_DecodeWays;

import java.util.*;

class DecodeWaysRecursion2Memo {
    public int numDecodings(String s) {
        HashMap<Integer, Integer> memorization = new HashMap<>();
        return getAns(s, 0, memorization);
    }

    private int getAns(String s, int start, HashMap<Integer, Integer> memorization) {
        if (start == s.length()) {
            return 1;
        }
        if (s.charAt(start) == '0') {
            return 0;
        }
        //判断之前是否计算过
        int m = memorization.getOrDefault(start, -1);
        if (m != -1) {
            return m;
        }
        int ans1 = getAns(s, start + 1, memorization);
        int ans2 = 0;
        if (start < s.length() - 1) {
            int ten = (s.charAt(start) - '0') * 10;
            int one = s.charAt(start + 1) - '0';
            if (ten + one <= 26) {
                ans2 = getAns(s, start + 2, memorization);
            }
        }
        //将结果保存
        memorization.put(start, ans1 + ans2);
        return ans1 + ans2;
    }
}

class DecodeWaysRecursion2MemoMain {
    public static void main(String[] args) {
        DecodeWaysRecursion2Memo decodeWays = new DecodeWaysRecursion2Memo();

        System.out.println(decodeWays.numDecodings("226"));
    }
}
