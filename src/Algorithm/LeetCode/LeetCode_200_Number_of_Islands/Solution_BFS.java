package Algorithm.LeetCode.LeetCode_200_Number_of_Islands;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class Solution_BFS {
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    bfs(grid, i, j);
                    grid[i][j] = '0';
                }
            }
        }

        return res;
    }

    void bfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Queue<Integer> q = new LinkedList<>();

        q.offer(i * n + j);

        while (!q.isEmpty()) {
            int num = q.poll();
            int x = num / n;
            int y = num % n;

            for (int[] d : directions) {
                int newX = x + d[0];
                int newY = y + d[1];

                if (newX >= 0 && newX < m
                        && newY >= 0 && newY < n
                        && grid[newX][newY] == '1') {
                    q.offer(newX * n + newY);
                    grid[newX][newY] = '0';
                }
            }
        }
    }
}