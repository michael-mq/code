package Algorithm.LeetCode.LeetCode_482_License_Key_Formatting;

class Solution {
    public String licenseKeyFormatting(String s, int k) {
        String _s = s.replace("-", "");

        if (_s.length() <= k) {
            return _s.toUpperCase();
        }

        char[] chars = _s.toCharArray();
        String res = "";
        int j = 0;

        for (int i = chars.length - 1; i >= 0; i--) {
            if (j != 0 && j % k == 0) {
                res = "-" + res;
            }

            res = chars[i] + res;
            j++;
        }

        return res.toUpperCase();
    }
}