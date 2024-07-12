package Algorithm.LeetCode.LeetCode_286_Walls_and_Gates;

import java.util.LinkedList;
import java.util.Queue;

class Solution_BFS_TimeOut {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    bfs(rooms, i, j);
                }
            }
        }
    }

    private void bfs(int[][] rooms, int i, int j) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(i * n + j);
        int dis = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                int num = queue.poll();

                for (int[] d : directions) {
                    int x = num / n + d[0];
                    int y = num % n + d[1];

                    if (x >= 0 && x < m && y >= 0 && y < n && rooms[x][y] > dis) {
                        queue.offer(x * n + y);
                    }
                }

                rooms[num / n][num % n] = Math.min(rooms[num / n][num % n], dis);
            }

            dis++;
        }
    }
}