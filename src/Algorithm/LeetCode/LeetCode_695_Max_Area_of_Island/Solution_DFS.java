package Algorithm.LeetCode.LeetCode_695_Max_Area_of_Island;

class Solution_DFS {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }

        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0; // important!
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int res = 1;

        for (int[] d : directions) {
            int x = i + d[0];
            int y = j + d[1];
            res += dfs(grid, x, y);
        }

        return res;
    }
}
