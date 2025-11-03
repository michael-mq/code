package Algorithm.LeetCode.LeetCode_777_Swap_Adjacent_in_LR_String;

// https://leetcode.cn/problems/swap-adjacent-in-lr-string/solutions/1864397/zhua-wa-mou-xiu-by-muse-77-tr3w
// https://leetcode.com/problems/swap-adjacent-in-lr-string/editorial

class Solution {
    public boolean canTransform(String start, String result) {
        if (!start.replace("X", "").equals(result.replace("X", ""))) {
            return false;
        }

        int j = 0;

        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'L') {
                while (result.charAt(j) != 'L') {
                    j++;
                }

                if (i < j++) {
                    return false;
                }
            }
        }

        j = 0;

        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'R') {
                while (result.charAt(j) != 'R') {
                    j++;
                }

                if (i > j++) {
                    return false;
                }
            }
        }

        return true;
    }
}