package Algorithm.LeetCode.LeetCode_56_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_MyOwn2 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > result.get(result.size() - 1)[1]) {
                result.add(intervals[i]);
            } else if (intervals[i][1] > result.get(result.size() - 1)[1]) {
                result.get(result.size() - 1)[1] = intervals[i][1];
            }
        }

        return result.toArray(new int[result.size()][2]);
    }
}