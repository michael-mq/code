package Algorithm.LeetCode.LeetCode_1091_Shortest_Path_in_Binary_Matrix;

import java.util.LinkedList;
import java.util.Queue;

// https://www.youtube.com/watch?v=CABaqOkWbgQ
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] != 0 || grid[m - 1][n - 1] != 0) {
            return -1;
        }

        int[][] directions = new int[][]{{1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        grid[0][0] = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();

                if (point[0] == m - 1 && point[1] == n - 1) {
                    return point[2];
                }

                for (int[] d : directions) {
                    int r = point[0] + d[0];
                    int c = point[1] + d[1];

                    if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 0) {
                        queue.add(new int[]{r, c, point[2] + 1});
                        grid[r][c] = 1;
                    }
                }
            }
        }

        return -1;
    }
}