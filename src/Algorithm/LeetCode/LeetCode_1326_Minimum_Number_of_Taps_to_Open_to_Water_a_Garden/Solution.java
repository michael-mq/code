package Algorithm.LeetCode.LeetCode_1326_Minimum_Number_of_Taps_to_Open_to_Water_a_Garden;

import java.util.Arrays;

// https://leetcode-cn.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/solution/java-tong-yong-de-yi-wei-qu-jian-jiao-bi-qfn0/
// https://www.youtube.com/watch?v=WHafLkS9_-E

/**
 * Sort by starting points:
 * the minimum number of intervals to cover the whole range
 * Sort by ending points:
 * the maximum number of *"non-overlapping"* intervals
 */
class Solution {
    public int minTaps(int n, int[] ranges) {
        int[][] intervals = new int[n + 1][2];

        for (int i = 0; i < ranges.length; i++) {
            intervals[i] = new int[]{i - ranges[i], i + ranges[i]};
        }

        Arrays.sort(intervals, (a, b) -> {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });

        int res = 0;
        int maxRight = 0;
        int i = 0;

        while (i <= n) {
            if (intervals[i][0] > maxRight) {
                break;
            }

            int tempRight = maxRight;

            while (i <= n && intervals[i][0] <= maxRight) {
                tempRight = Math.max(tempRight, intervals[i][1]);
                i++;
            }

            maxRight = tempRight;

            res++;

            if (maxRight >= n) {
                break;
            }
        }

        return maxRight >= n ? res : -1;
    }
}
