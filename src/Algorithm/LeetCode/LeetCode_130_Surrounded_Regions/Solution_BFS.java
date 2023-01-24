package Algorithm.LeetCode.LeetCode_130_Surrounded_Regions;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution_BFS {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {
                    queue.offer(i * n + j);
                    board[i][j] = '#';
                }
            }
        }

        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            int index = queue.poll();

            int x = index / n;
            int y = index % n;

            for (int[] direction: directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (newX >= 0 && newY >= 0 && newX < m && newY < n && board[newX][newY] == 'O') {
                    board[newX][newY] = '#';
                    queue.offer(newX * n + newY);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}