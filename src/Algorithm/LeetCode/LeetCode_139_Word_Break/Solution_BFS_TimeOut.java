package Algorithm.LeetCode.LeetCode_139_Word_Break;

import java.util.*;

//https://leetcode.cn/problems/word-break/solutions/302779/shou-hui-tu-jie-san-chong-fang-fa-dfs-bfs-dong-tai
class Solution_BFS_TimeOut {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Queue<String> queue = new LinkedList<>();

        queue.offer(s);

        while (!queue.isEmpty()) {
            String str = queue.poll();

            for (int i = 1; i <= str.length(); i++) {
                String subStr = str.substring(0, i);
                if (set.contains(subStr)) {
                    if (i == str.length()) {
                        return true;
                    }

                    queue.offer(str.substring(i));
                }
            }
        }

        return false;
    }
}