package Algorithm.LeetCode.LeetCode_542_01_Matrix;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.cn/problems/01-matrix/solutions/202012/01ju-zhen-by-leetcode-solution/
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] seen = new boolean[m][n];
        int[][] directions = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    seen[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !seen[newX][newY]) {
                    mat[newX][newY] = mat[x][y] + 1;
                    seen[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        return mat;
    }
}