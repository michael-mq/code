package Algorithm.LeetCode.CN.Offer_05;

// https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
class Solution {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder str = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                str.append("   ");
            }
        }

        if (str.length() == 0) {
            return s;
        }

        int left = s.length() - 1;
        s += str.toString();
        int right = s.length() - 1;
        char[] chars = s.toCharArray();

        while (left >= 0) {
            if (chars[left] != ' ') {
                chars[right] = chars[left];
            } else {
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right] = '%';
            }
            left--;
            right--;
        }

        return new String(chars);
    }
}