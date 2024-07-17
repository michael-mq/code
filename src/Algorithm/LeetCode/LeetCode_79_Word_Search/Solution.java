package Algorithm.LeetCode.LeetCode_79_Word_Search;

class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, 0, word)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int index, String word) {
        int length = word.length();

        if (index == length - 1) {
            return true;
        }

        char temp = board[i][j];
        board[i][j] = '0';

        int m = board.length;
        int n = board[0].length;

        int[][] directions = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

        for (int[] d : directions) {
            int x = i + d[0];
            int y = j + d[1];

            if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == word.charAt(index + 1)) {
                if (dfs(board, x, y, index + 1, word)) {
                    return true;
                }
            }
        }

        board[i][j] = temp;

        return false;
    }
}