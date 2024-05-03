package Algorithm.LeetCode.LeetCode_131_Palindrome_Partitioning;

import java.util.ArrayList;
import java.util.List;

//https://www.programmercarl.com/0131.分割回文串.html
public class Solution_BackTrack_TwoPointer {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backTrack(s, 0, new ArrayList<>(), res);

        return res;
    }

    private void backTrack(String s, int startIndex, List<String> path, List<List<String>> res) {
        if (startIndex == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String str = s.substring(startIndex, i + 1);

            if (isPalindrome(str)) {
                path.add(str);
                backTrack(s, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}
