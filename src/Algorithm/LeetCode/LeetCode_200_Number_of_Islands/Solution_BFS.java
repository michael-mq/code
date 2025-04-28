package Algorithm.LeetCode.LeetCode_200_Number_of_Islands;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class Solution_BFS {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    bfs(grid, i, j);
                }
            }
        }

        return ans;
    }

    private void bfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(n * i + j);
        grid[i][j] = '0';

        while (!queue.isEmpty()) {
            int num = queue.poll();

            int x = num / n;
            int y = num % n;

            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (newX >= 0 && newY >= 0 && newX < m && newY < n && grid[newX][newY] == '1') {
                    queue.offer(n * newX + newY);
                    grid[newX][newY] = '0';
                }
            }
        }
    }
}