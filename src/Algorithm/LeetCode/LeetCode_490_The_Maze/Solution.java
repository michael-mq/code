package Algorithm.LeetCode.LeetCode_490_The_Maze;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/the-maze/solutions/97071/easy-understanding-java-bfs-solution/
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<Integer> queue = new LinkedList<>();
        int m = maze.length;
        int n = maze[0].length;
        int[][] directions = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        boolean[] visited = new boolean[m * n];

        int startIndex = start[0] * n + start[1];
        int destinationIndex = destination[0] * n + destination[1];

        if (startIndex == destinationIndex) {
            return true;
        }

        visited[startIndex] = true;
        queue.offer(startIndex);

        while (!queue.isEmpty()) {
            int index = queue.poll();
            int x = index / n;
            int y = index % n;

            for (int[] direction : directions) {
                int newX = x;
                int newY = y;

                while (newX >= 0 && newX < m && newY >= 0 && newY < n && maze[newX][newY] == 0) {
                    newX += direction[0];
                    newY += direction[1];
                }

                newX -= direction[0];
                newY -= direction[1];

                int newIndex = newX * n + newY;

                if (newIndex == destinationIndex) {
                    return true;
                }

                if (visited[newIndex]) {
                    continue;
                }

                visited[newIndex] = true;
                queue.offer(newIndex);
            }
        }

        return false;
    }
}
