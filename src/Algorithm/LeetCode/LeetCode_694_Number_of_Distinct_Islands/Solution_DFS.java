package Algorithm.LeetCode.LeetCode_694_Number_of_Distinct_Islands;

import java.util.HashSet;
import java.util.Set;

// https://www.youtube.com/watch?v=u617H2WwR5g
public class Solution_DFS {
    private final int WATER = 0;
    private final int[][] DIRECTIONS = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    private int[][] grid;
    private int m;
    private int n;
    private int baseRow;
    private int baseCol;

    public int numDistinctIslands(int[][] grid) {
        Set<String> shapes = new HashSet<>();
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == WATER) {
                    continue;
                }

                baseRow = i;
                baseCol = j;
                StringBuilder sb = new StringBuilder();

                dfs(i, j, sb);

                shapes.add(sb.toString());
            }
        }

        return shapes.size();
    }

    private void dfs(int row, int col, StringBuilder sb) {
        if (row < 0 || col < 0 || row >= m || col >= n) {
            return;
        }

        if (grid[row][col] == WATER) {
            return;
        }

        sb.append(baseRow - row);
        sb.append(baseCol - col);

        grid[row][col] = WATER;

        for (int[] direction : DIRECTIONS) {
            dfs(row + direction[0], col + direction[1], sb);
        }
    }
}
