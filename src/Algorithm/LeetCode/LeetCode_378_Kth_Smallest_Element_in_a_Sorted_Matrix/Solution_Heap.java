package Algorithm.LeetCode.LeetCode_378_Kth_Smallest_Element_in_a_Sorted_Matrix;
//https://www.youtube.com/watch?v=Lo23qFLhJNY

import java.util.PriorityQueue;

public class Solution_Heap {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[n][n];
        minHeap.offer(new int[]{matrix[0][0], 0, 0});

        for (int v = 0; v < k - 1; v++) {
            int[] top = minHeap.poll();

            int i = top[1];
            int j = top[2];

            if (i + 1 < n && !visited[i+1][j]) {
                visited[i + 1][j] = true;
                minHeap.offer(new int[]{matrix[i + 1][j], i + 1, j});
            }

            if (j + 1 < n && !visited[i][j + 1]) {
                visited[i][j + 1] = true;
                minHeap.offer(new int[]{matrix[i][j + 1], i, j + 1});
            }
        }

        return minHeap.peek()[0];
    }
}
