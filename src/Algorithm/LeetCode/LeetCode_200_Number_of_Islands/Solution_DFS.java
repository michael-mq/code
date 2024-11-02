package Algorithm.LeetCode.LeetCode_200_Number_of_Islands;

class Solution_DFS {
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                    grid[i][j] = '0';
                }
            }
        }

        return res;
    }

    void dfs(char[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int[] d : directions) {
            int newX = x + d[0];
            int newY = y + d[1];

            if (newX >= 0 && newX < m
                    && newY >= 0 && newY < n
                    && grid[newX][newY] == '1') {
                grid[newX][newY] = '0';
                dfs(grid, newX, newY);
            }
        }
    }
}