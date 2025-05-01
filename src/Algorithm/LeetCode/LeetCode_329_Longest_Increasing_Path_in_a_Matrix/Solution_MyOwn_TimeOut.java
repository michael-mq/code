package Algorithm.LeetCode.LeetCode_329_Longest_Increasing_Path_in_a_Matrix;

class Solution_MyOwn_TimeOut {
    int ans = 0;

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(matrix, i, j, 1);
            }
        }

        return ans;
    }

    private void dfs(int[][] matrix, int i, int j, int dist) {
        ans = Math.max(ans, dist);

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];

            if (x >= 0 && y >= 0 && x < m && y < n && matrix[x][y] > matrix[i][j]) {
                dfs(matrix, x, y, dist + 1);
            }
        }
    }
}