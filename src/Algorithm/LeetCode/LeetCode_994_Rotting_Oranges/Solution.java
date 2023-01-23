package Algorithm.LeetCode.LeetCode_994_Rotting_Oranges;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[][] directions = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        Queue<Integer> queue = new LinkedList<>();
        int minutes = 0;
        int fresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(i * n + j);
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        while (!queue.isEmpty() && fresh != 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                int x = index / n;
                int y = index % n;

                for (int[] direction : directions) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];

                    if (newX >= 0 && newY >= 0 && newX < m && newY < n && grid[newX][newY] != 2 && grid[newX][newY] != 0) {
                        queue.offer(newX * n + newY);
                        fresh--;
                        grid[newX][newY] = 2;
                    }
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}