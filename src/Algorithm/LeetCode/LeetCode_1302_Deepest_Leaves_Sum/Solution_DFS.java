package Algorithm.LeetCode.LeetCode_1302_Deepest_Leaves_Sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution_DFS {
    int maxLevel = 0;

    public int deepestLeavesSum(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        dfs(root, map, 0);

        List<Integer> maxList = map.get(maxLevel);

        return maxList.stream().mapToInt(i -> i).sum();
    }

    void dfs(TreeNode root, Map<Integer, List<Integer>> map, int level) {
        if (root == null) {
            return;
        }

        level++;
        maxLevel = Math.max(maxLevel, level);

        List<Integer> list = map.computeIfAbsent(level, k -> new ArrayList<>());
        list.add(root.val);

        dfs(root.left, map, level);
        dfs(root.right, map, level);
    }
}