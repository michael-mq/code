package Algorithm.LeetCode.LeetCode_139_Word_Break;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.cn/problems/word-break/solutions/302779/shou-hui-tu-jie-san-chong-fang-fa-dfs-bfs-dong-tai/
class Solution_DFS_Memo {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int[] memo = new int[s.length() + 1];

        for (int i = 0; i <= s.length(); i++) {
            memo[i] = -1;
        }

        return dfs(s, 0, set, memo);
    }

    private boolean dfs(String s, int start, Set<String> set, int[] memo) {
        if (memo[start] != -1) {
            return memo[start] == 1;
        }

        if (start == s.length()) {
            memo[start] = 1;
            return true;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            if (set.contains(s.substring(start, i)) && dfs(s, i, set, memo)) {
                memo[i] = 1;
                return true;
            }
        }

        memo[start] = 0;
        return false;
    }
}