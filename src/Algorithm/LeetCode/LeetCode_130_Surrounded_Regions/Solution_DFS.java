package Algorithm.LeetCode.LeetCode_130_Surrounded_Regions;

public class Solution_DFS {
    void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O')
                    dfs(board, i, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';

                if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;

        if (i < 0 || j < 0 || i > m - 1 || j > n - 1 || board[i][j] == 'X' || board[i][j] == '#')
            return;

        board[i][j] = '#';

        int[][] d = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int k = 0; k < 4; k++) {
            dfs(board, i + d[k][0], j + d[k][1]);
        }
    }
}
