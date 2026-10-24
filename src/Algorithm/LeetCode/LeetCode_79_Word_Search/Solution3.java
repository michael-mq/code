package Algorithm.LeetCode.LeetCode_79_Word_Search;

class Solution3 {
    private int[][] directions;
    private int m;
    private int n;

    public boolean exist(char[][] board, String word) {
        directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];

                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;

                    if (dfs(board, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;

    }

    private boolean dfs(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if (index == word.length() - 1) {
            return true;
        }

        for (int[] d : directions) {
            int x = i + d[0];
            int y = j + d[1];

            if (x >= 0 && y >= 0 && x < m && y < n && !visited[x][y] && word.charAt(index + 1) == board[x][y]) {
                visited[x][y] = true;

                if (dfs(board, word, x, y, index + 1, visited)) {
                    return true;
                }

                visited[x][y] = false;
            }
        }

        return false;
    }
}