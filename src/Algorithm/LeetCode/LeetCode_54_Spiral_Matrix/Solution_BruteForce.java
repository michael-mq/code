package Algorithm.LeetCode.LeetCode_54_Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

class Solution_BruteForce {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        if (matrix.length == 0) {
            return res;
        }

        int[][] directions = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int i, j = 0;

        dfs(matrix, 0, 0, "right", res, visited);

        return res;
    }

    public void dfs(int[][] matrix, int i, int j, String direction, List<Integer> res, boolean[][] visited) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        res.add(matrix[i][j]);

        if (direction.equals("right")) {
            if (j < matrix[0].length - 1 && !visited[i][j + 1]) {
                dfs(matrix, i, j + 1, "right", res, visited);
            } else {
                dfs(matrix, i + 1, j, "down", res, visited);
            }

        } else if (direction.equals("down")) {
            if (i < matrix.length - 1 && !visited[i + 1][j]) {
                dfs(matrix, i + 1, j, "down", res, visited);
            } else {
                dfs(matrix, i, j - 1, "left", res, visited);
            }
        } else if (direction.equals("left")) {
            if (j > 0 && !visited[i][j - 1]) {
                dfs(matrix, i, j - 1, "left", res, visited);
            } else {
                dfs(matrix, i - 1, j, "up", res, visited);
            }
        } else if (direction.equals("up")) {
            if (i > 0 && !visited[i - 1][j]) {
                dfs(matrix, i - 1, j, "up", res, visited);
            } else {
                dfs(matrix, i, j + 1, "right", res, visited);
            }
        }
    }
}
