package Algorithm.LeetCode.LeetCode_973_K_Closest_Points_to_Origin;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_Heap {
    public int[][] kClosest(int[][] points, int k) {
        Queue<double[]> maxHeap = new PriorityQueue<>((a, b) -> (int) (b[1] - a[1]));

        for (int i = 0; i < points.length; i++) {
            double distance = Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2);
            double[] point = new double[]{i, distance};

            maxHeap.offer(point);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][];

        for (int i = 0; i < res.length; i++) {
            int index = (int) maxHeap.poll()[0];
            res[i] = points[index];
        }

        return res;
    }
}