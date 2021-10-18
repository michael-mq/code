package Algorithm.LeetCode.LeetCode_131_Palindrome_Partitioning;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        List<List<String>> result = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();

        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }

        dfs(s, 0, path, result, dp);

        return result;
    }

    private void dfs(String s, int index, Deque<String> path, List<List<String>> result, boolean[][] dp) {
        if (index == s.length()) {
            result.add(new ArrayList<>(path));
        }

        for (int i = index; i < s.length(); i++) {
            if (dp[index][i]) {
                path.addLast(s.substring(index, i + 1));

                dfs(s, i + 1, path, result, dp);

                path.removeLast();
            }
        }
    }
}
