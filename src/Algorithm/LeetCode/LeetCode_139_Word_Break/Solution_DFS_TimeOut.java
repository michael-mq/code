package Algorithm.LeetCode.LeetCode_139_Word_Break;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.cn/problems/word-break/solutions/302779/shou-hui-tu-jie-san-chong-fang-fa-dfs-bfs-dong-tai/
class Solution_DFS_TimeOut {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        return dfs(s, 0, set);
    }

    private boolean dfs(String s, int start, Set<String> set) {
        if (start == s.length()) {
            return true;
        }

        for (int i = start + 1; i <= s.length(); i++) {
//            Failed at s = "aaaaaaa"
//            wordDict = ["aaaa","aaa"]
//            if (set.contains(s.substring(start, i))) {
//                return dfs(s, i, set);
//            }

            if (set.contains(s.substring(start, i)) && dfs(s, i, set)) {
                return true;
            }
        }

        return false;
    }
}