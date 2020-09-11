package Algorithm.LeetCode.LeetCode_973_K_Closest_Points_to_Origin;

import java.util.Arrays;

public class Solution_Sort {
    public int[][] kClosest(int[][] points, int K) {
        int len = points.length;

        int[] distances = new int[len];

        for (int i = 0; i < len; ++i)
            distances[i] = getDistance(points[i]);

        Arrays.sort(distances);

        int distK = distances[K - 1];

        int[][] ans = new int[K][2];
        int t = 0;

        for (int i = 0; i < len; ++i) {
            if (getDistance(points[i]) <= distK) {
                ans[t++] = points[i];
            }
        }

        return ans;
    }

    public int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
