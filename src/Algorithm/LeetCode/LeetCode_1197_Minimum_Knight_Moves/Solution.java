package Algorithm.LeetCode.LeetCode_1197_Minimum_Knight_Moves;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);

        int[][] directions = new int[][]{{1, 2}, {2, 1}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        Set<String> visited = new HashSet<>();
        visited.add("0,0");

        int res = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();

                if (cur[0] == x && cur[1] == y) {
                    return res;
                }

                for (int[] d : directions) {
                    int newX = cur[0] + d[0];
                    int newY = cur[1] + d[1];

                    if (!visited.contains(newX + "," + newY) && newX >= -1 && newY >= -1) {
                        queue.add(new int[]{newX, newY});
                        visited.add(newX + "," + newY);
                    }
                }

            }
            res++;
        }

        return -1;
    }
}
