package Algorithm.LeetCode.LeetCode_200_Number_of_Islands;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution_BFS {
    public int numIslands(char[][] grid) {
        int count = 0;

        if (grid == null && grid.length == 0) {
            return count;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        int[][] directions = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        Queue<Integer> queue = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;

        queue.offer(i * n + j);

        while (!queue.isEmpty()) {
            int num = queue.poll();
            int x = num / n;
            int y = num % n;

            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (newX >= 0 && newX < m && newY >=0 && newY < n && grid[newX][newY] == '1') {
                    grid[newX][newY] = '2';
                    queue.offer(newX * n + newY);
                }
            }
        }
    }
}