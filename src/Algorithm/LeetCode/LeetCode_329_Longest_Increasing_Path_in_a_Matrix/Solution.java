package Algorithm.LeetCode.LeetCode_329_Longest_Increasing_Path_in_a_Matrix;

public class Solution {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int rows, columns;
    private int[][] memo;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        rows = matrix.length;
        columns = matrix[0].length;
        memo = new int[rows][columns];
        int ans = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }

        return ans;
    }

    private int dfs(int[][] matrix, int row, int column) {
        if (memo[row][column] != 0) {
            return memo[row][column];
        }

        int max = 0;

        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newColumn = column + dir[1];

            if (newRow >= 0 && newColumn >= 0 && newRow < rows && newColumn < columns && matrix[newRow][newColumn] > matrix[row][column]) {
                max = Math.max(max, dfs(matrix, newRow, newColumn));
            }
        }

        memo[row][column] = max + 1;

        return memo[row][column];
    }
}
