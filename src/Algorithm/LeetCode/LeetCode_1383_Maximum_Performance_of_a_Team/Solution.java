package Algorithm.LeetCode.LeetCode_1383_Maximum_Performance_of_a_Team;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://www.youtube.com/watch?v=2hQgKotGA7o

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        final int MOD = 1000000007;
        int[][] engineers = new int[n][2];

        for (int i = 0; i < n; i++) {
            engineers[i][0] = speed[i];
            engineers[i][1] = efficiency[i];
        }

        Arrays.sort(engineers, (a, b) -> b[1] - a[1]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        long res = 0;
        long speedSum = 0;

        for (int i = 0; i < n; i++) {
            int[] engineer = engineers[i];

            int minEfficiency = engineer[1];
            speedSum += engineer[0];

            res = Math.max(res, minEfficiency * speedSum);

            minHeap.offer(engineer);

            if (minHeap.size() == k) {
                speedSum -= minHeap.poll()[0];
            }
        }

        return (int) (res % MOD);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.maxPerformance(
                6,
                new int[]{2, 10, 3, 1, 5, 8},
                new int[]{5, 4, 3, 9, 7, 2},
                2
        ));
    }
}
