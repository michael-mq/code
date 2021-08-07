package Algorithm.LeetCode.LeetCode_1383_Maximum_Performance_of_a_Team;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineers = new int[n][2];

        for (int i = 0; i < n; i++) {
            engineers[i][0] = speed[i];
            engineers[i][1] = efficiency[i];
        }

        Arrays.sort(engineers, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        long res = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            int[] engineer = engineers[i];

            long curMin = engineer[1];
            long curTotal = sum + engineer[0];

            res = Math.max(res, curTotal * curMin);

            sum = curTotal;

            queue.offer(engineer);

            if (queue.size() == k)
                sum -= queue.poll()[0];
        }

        return (int) (res % ((int) 1e9 + 7));
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
