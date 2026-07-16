package Algorithm.LeetCode.LeetCode_56_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_MyOwn3 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();

        int a = intervals[0][0];
        int b = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > b) {
                ans.add(new int[]{a, b});
                a = intervals[i][0];
                b = intervals[i][1];
            } else {
                a = Math.min(a, intervals[i][0]);
                b = Math.max(b, intervals[i][1]);
            }

            if (i == intervals.length - 1) {
                ans.add(new int[]{a, b});
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}