package Algorithm.LeetCode.LeetCode_130_Surrounded_Regions;

class Solution_Test {
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    if (isConnectedToBoardZero(board, i, j, visited)) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }

    private boolean isConnectedToBoardZero(char[][] board, int i, int j, boolean[][] visited) {
        if (visited[i][j]) {
            return false;
        }

        visited[i][j] = true;

        if (isOnBoard(board, i, j)) {
            return true;
        }

        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int[] d : directions) {
            int x = i + d[0];
            int y = j + d[1];

            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O') {
                if (isConnectedToBoardZero(board, x, y, visited)) {
                    return true;
                } else {
                    visited[x][y] = false;
                }
            }
        }

        return false;

    }

    private boolean isOnBoard(char[][] board, int i, int j) {
        if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_Test s = new Solution_Test();

        s.solve(new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        });
    }
}

