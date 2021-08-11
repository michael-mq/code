package Algorithm.LeetCode.LeetCode_973_K_Closest_Points_to_Origin;

import java.util.PriorityQueue;

public class Solution_Heap {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> queue = new PriorityQueue<>((a, b) -> (int) (b[1] - a[1]));

        for (int i = 0; i < points.length; i++) {
            double distance = Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2);

            double[] point = new double[]{i, distance};
            queue.offer(point);

            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[][] res = new int[k][];
        int index = 0;

        while (!queue.isEmpty()) {
            int n = (int) queue.peek()[0];
            res[index++] = points[n];
        }

        return res;
    }
}
