package Algorithm.LeetCode.LeetCode_934_Shortest_Bridge;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;

        Queue<int[]> queue = new LinkedList<>();

        boolean marked = false;
        // Loop from (0, 0), once found 1, dfs find all connected 1s. Marked it as found, no need to loop anymore.
        for (int i = 0; i < n; i++) {
            if (marked) {
                break;
            }

            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue);
                    marked = true;

                    break;
                }
            }
        }

        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int[] island = queue.poll();

                for (int[] direction : directions) {
                    int r = island[0] + direction[0];
                    int c = island[1] + direction[1];

                    if (r >= 0 && r < n && c >= 0 && c < n) {
                        if (grid[r][c] == 1) {
                            return res;
                        }

                        if (grid[r][c] == 0) {
                            grid[r][c] = 2;
                            queue.offer(new int[]{r, c});
                        }
                    }
                }
            }

            res++;
        }

        return res;
    }

    private void dfs(int[][] grid, int i, int j, Queue<int[]> queue) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || grid[i][j] == 2) {
            return;
        }

        grid[i][j] = 2;
        queue.offer(new int[]{i, j});

        for (int[] direction : directions) {
            dfs(grid, i + direction[0], j + direction[1], queue);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] foo = new int[][]{
                {0, 1, 0}, {0, 0, 0}, {0, 0, 1}
        };

        System.out.println(solution.shortestBridge(foo));
    }
}


//        [1,1,1,1,1],
//        [1,0,0,0,1],
//        [1,0,1,0,1],
//        [1,0,0,0,1],
//        [1,1,1,1,1]

//        [0,1,0],
//        [0,0,0],
//        [0,0,1]
