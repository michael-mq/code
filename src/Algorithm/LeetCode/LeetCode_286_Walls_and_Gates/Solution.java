package Algorithm.LeetCode.LeetCode_286_Walls_and_Gates;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;

    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == GATE) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] room = queue.poll();

                int row = room[0];
                int col = room[1];

                for (int[] d : DIRECTIONS) {
                    int newRow = row + d[0];
                    int newCol = col + d[1];

                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && rooms[newRow][newCol] == EMPTY) {
                        queue.offer(new int[]{newRow, newCol});
                        rooms[newRow][newCol] = rooms[row][col] + 1;
                    }
                }
            }
        }

//        int dist = 1;
//
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//
//            for (int i = 0; i < size; i++) {
//                int[] room = queue.poll();
//
//                int row = room[0];
//                int col = room[1];
//
//                for (int[] d : DIRECTIONS) {
//                    int newRow = row + d[0];
//                    int newCol = col + d[1];
//
//                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && rooms[newRow][newCol] == EMPTY) {
//                        queue.offer(new int[]{newRow, newCol});
//                        rooms[newRow][newCol] = dist;
//                    }
//                }
//            }
//
//            dist++;
//        }
    }
}