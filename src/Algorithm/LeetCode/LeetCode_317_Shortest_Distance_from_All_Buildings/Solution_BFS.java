package Algorithm.LeetCode.LeetCode_317_Shortest_Distance_from_All_Buildings;

import java.util.LinkedList;
import java.util.Queue;

//https://www.youtube.com/watch?v=F7AM7AGJZYE

class Solution_BFS {
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] reaches = new int[m][n]; // how many 1s can this point reach
        int[][] distances = new int[m][n]; // what's the total distances from this point to all 1s
        int totalBuildings = 0; // total buildings in the grid

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    totalBuildings++;
                    bfs(grid, i, j, reaches, distances);
                }
            }
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (reaches[i][j] == totalBuildings) {
                    res = Math.min(res, distances[i][j]);
                }
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void bfs(int[][] grid, int i, int j, int[][] reaches, int[][] distances) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int dist = 0;

        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {
            int size = queue.size();
            dist++;

            for (int k = 0; k < size; k++) {
                int[] point = queue.poll();

                for (int[] d : directions) {
                    int x = point[0] + d[0];
                    int y = point[1] + d[1];

                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        reaches[x][y]++;
                        distances[x][y] += dist;
                        queue.offer(new int[]{x, y});
                    }
                }
            }

        }

    }
}
