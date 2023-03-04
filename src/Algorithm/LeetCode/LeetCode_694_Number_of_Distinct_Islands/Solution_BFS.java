package Algorithm.LeetCode.LeetCode_694_Number_of_Distinct_Islands;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// https://www.youtube.com/watch?v=u617H2WwR5g
public class Solution_BFS {
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

                bfs(i, j, sb);

                shapes.add(sb.toString());
            }
        }

        return shapes.size();
    }

    private void bfs(int row, int col, StringBuilder sb) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        grid[row][col] = WATER;

        while (!queue.isEmpty()) {
            int[] q = queue.poll();

            sb.append(baseRow - q[0]);
            sb.append(baseCol - q[1]);

            for (int[] direction : DIRECTIONS) {
                int newRow = q[0] + direction[0];
                int newCol = q[1] + direction[1];

                if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && grid[newRow][newCol] != WATER) {
                    queue.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = WATER;
                }
            }
        }
    }
}
