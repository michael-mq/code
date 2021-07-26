package Algorithm.LeetCode.LeetCode_56_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();

        res.add(intervals[0]);

        for (int[] interval : intervals) {
            int[] last = res.get(res.size() - 1);

            if (interval[0] <= last[1]) {
                last[1] = Math.max(interval[1], last[1]);
            } else {
                res.add(interval);
            }
        }

        return res.toArray(new int[res.size()][2]);
    }
}
