package Algorithm.LeetCode.LeetCode_394_Decode_String;

// https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/
class Solution_Recursion {
    public String decodeString(String s) {
        return dfs(s, 0)[0];
    }

    private String[] dfs(String s, int i) {
        StringBuilder res = new StringBuilder();

        int multi = 0;

        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            else if (s.charAt(i) == '[') {
                String[] tmp = dfs(s, i + 1);
                i = Integer.parseInt(tmp[0]);

                while (multi > 0) {
                    res.append(tmp[1]);
                    multi--;
                }
            } else if (s.charAt(i) == ']') {
                return new String[]{String.valueOf(i), res.toString()};
            } else {
                res.append(String.valueOf(s.charAt(i)));
            }

            i++;
        }

        return new String[]{res.toString()};
    }
}
