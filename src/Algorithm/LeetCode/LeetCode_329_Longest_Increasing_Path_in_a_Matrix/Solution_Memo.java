package Algorithm.LeetCode.LeetCode_329_Longest_Increasing_Path_in_a_Matrix;

public class Solution_Memo {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }

        return ans;
    }

    private int dfs(int[][] matrix, int row, int col, int[][] memo) {
        if (memo[row][col] != 0) {
            return memo[row][col];
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int max = 0;

        for (int[] d : directions) {
            int newRow = row + d[0];
            int newCol = col + d[1];

            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && matrix[newRow][newCol] > matrix[row][col]) {
                max = Math.max(max, dfs(matrix, newRow, newCol, memo));
            }
        }

        memo[row][col] = max + 1;

        return memo[row][col];
    }
}
