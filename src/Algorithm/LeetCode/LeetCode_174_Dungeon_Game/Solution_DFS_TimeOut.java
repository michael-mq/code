package Algorithm.LeetCode.LeetCode_174_Dungeon_Game;

//https://leetcode.cn/problems/dungeon-game/solutions/24493/cong-hui-su-dao-ji-yi-hua-sou-suo-dao-dong-tai-gui/
class Solution_DFS_TimeOut {
    public int calculateMinimumHP(int[][] dungeon) {
        return dfs(dungeon, 0, 0) + 1;
    }

    private int dfs(int[][] dungeon, int i, int j) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        if (i == m - 1 && j == n - 1) {
            if (dungeon[i][j] >= 0) {
                return 0;
            } else {
                return -dungeon[i][j];
            }
        }

        int right = dfs(dungeon, i, j + 1);
        int down = dfs(dungeon, i + 1, j);

        return Math.max(Math.min(right, down) - dungeon[i][j], 0);
    }
}