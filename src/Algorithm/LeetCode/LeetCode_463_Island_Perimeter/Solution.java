package Algorithm.LeetCode.LeetCode_463_Island_Perimeter;

class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int island = 0, adjacent = 0;

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    island++;

                    if (i > 0 && grid[i - 1][j] == 1) adjacent++;
                    if (j > 0 && grid[i][j - 1] == 1) adjacent++;
                    if (i < m - 1 && grid[i + 1][j] == 1) adjacent++;
                    if (j < n - 1 && grid[i][j + 1] == 1) adjacent++;

                }
            }
        }

        return island * 4 - adjacent;
    }
}
