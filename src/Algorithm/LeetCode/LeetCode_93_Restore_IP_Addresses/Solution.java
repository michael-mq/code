package Algorithm.LeetCode.LeetCode_93_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.List;
//https://www.programmercarl.com/0093.复原IP地址.html
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();

        if (s.length() < 4 || s.length() > 12) {
            return res;
        }

        backTrack(s, 0, 0, res);

        return res;
    }

    private void backTrack(String s, int startIndex, int pointNum, List<String> res) {
        if (pointNum == 3) {
            if (isValid(s, startIndex, s.length() - 1)) {
                res.add(s);
            }

            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (!isValid(s, startIndex, i)) {
                break;
            }

            s = s.substring(0, i + 1) + "." + s.substring(i + 1);
            pointNum++;
            backTrack(s, i + 2, pointNum, res);
            pointNum--;
            s = s.substring(0, i + 1) + s.substring(i + 2);
        }
    }

    private boolean isValid(String s, int start, int end) {
        if (start > end || end - start > 2) {
            return false;
        }

        if (s.charAt(start) == '0' && start != end) {
            return false;
        }

        int num = 0;

        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }

            num = num * 10 + (s.charAt(i) - '0');

            if (num > 255) {
                return false;
            }
        }

        return true;
    }
}