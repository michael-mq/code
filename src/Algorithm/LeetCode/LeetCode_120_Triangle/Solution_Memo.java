package Algorithm.LeetCode.LeetCode_120_Triangle;

import java.util.List;
//https://leetcode.cn/problems/triangle/solutions/329394/di-gui-ji-yi-hua-dp-bi-xu-miao-dong-by-sweetiee/

class Solution_Memo {
    public int minimumTotal(List<List<Integer>> triangle) {
        return dfs(triangle, 0, 0, new Integer[triangle.size()][triangle.size()]);
    }

    private int dfs(List<List<Integer>> triangle, int i, int j, Integer[][] memo) {
        if (i == triangle.size()) {
            return 0;
        }

        if (memo[i][j] == null) {
            memo[i][j] = Math.min(dfs(triangle, i + 1, j, memo), dfs(triangle, i + 1, j + 1, memo)) + triangle.get(i).get(j);
        }

        return memo[i][j];
    }
}